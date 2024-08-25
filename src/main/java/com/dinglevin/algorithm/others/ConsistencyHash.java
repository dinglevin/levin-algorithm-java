package com.dinglevin.algorithm.others;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 描述：ConsistencyHash
 *
 * @author dinglevin
 * @since 2021/6/7 16:29 周一
 */
public class ConsistencyHash {
    private NodeLocator nodeLocator;

    public ConsistencyHash(List<String> nodeList) {
        this.nodeLocator = new KetamaNodeLocator(nodeList);
    }

    public String getPrimaryNode(String key) {
        return nodeLocator.getPrimaryNode(key);
    }

    public interface NodeLocator {
        String getPrimaryNode(String key);
    }

    public static class KetamaNodeLocator implements NodeLocator {
        private static final int DEFAULT_REPETITIONS = 1024;
        private static final int DEFAULT_NUM_REPETITIONS_DIVIDE = 4;

        private final KetamaData data;

        public KetamaNodeLocator(List<String> nodeList) {
            this.data = buildKetamaData(nodeList);
        }

        @Override
        public String getPrimaryNode(String key) {
            return getNodeForKey(MD5Utils.hash(key));
        }

        private String getNodeForKey(long hash) {
            long target = hash;
            if (!data.containsHash(target)) {
                SortedMap<Long, String> tailMap = data.getNodeMap().tailMap(target);
                target = tailMap.isEmpty() ? data.getNodeMap().firstKey() : tailMap.firstKey();
            }

            return data.getNodeMap().get(target);
        }

        private KetamaData buildKetamaData(List<String> nodeList) {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(nodeList), "nodeList is null or empty");

            Map<String, Integer> nodeCountMap = Maps.newTreeMap();
            KetamaData data = new KetamaData();
            for (String node : nodeList) {
                Preconditions.checkState(StringUtils.isNotBlank(node), "node is blank");

                int nodeCount = nodeCountMap.getOrDefault(node, 0) + 1;
                nodeCountMap.put(node, nodeCount);
                data.addNode(node);

                String enrichedNode = concat(node, nodeCount);
                for (int i = 0; i < DEFAULT_REPETITIONS / DEFAULT_NUM_REPETITIONS_DIVIDE; i++) {
                    byte[] digest = MD5Utils.computeMd5(concat(enrichedNode, i));
                    for (int j = 0; j < DEFAULT_NUM_REPETITIONS_DIVIDE; j++) {
                        data.putNodeMap(MD5Utils.digestHash(digest, j), node);
                    }
                }
            }

            return data;
        }

        private String concat(String prefix, int number) {
            return prefix + "%" + number + "%";
        }
    }

    private static class KetamaData {
        private TreeMap<Long, String> nodeMap;
        private Set<String> nodeSet;

        public KetamaData() {
            this(Maps.newTreeMap(), Sets.newHashSet());
        }

        public KetamaData(TreeMap<Long, String> nodeMap, Set<String> nodeSet) {
            this.nodeMap = nodeMap;
            this.nodeSet = nodeSet;
        }

        public void addNode(String node) {
            nodeSet.add(node);
        }

        public void putNodeMap(Long key, String node) {
            nodeMap.put(key, node);
        }

        public boolean containsHash(Long hash) {
            return nodeMap.containsKey(hash);
        }

        public TreeMap<Long, String> getNodeMap() {
            return nodeMap;
        }

        public Set<String> getNodeSet() {
            return nodeSet;
        }
    }

    private static class MD5Utils {
        public static byte[] computeMd5(String value) {
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(value.getBytes(StandardCharsets.UTF_8));
                return digest.digest();
            } catch (Exception ex) {
                throw new RuntimeException("computeMd5 failed: " + value, ex);
            }
        }

        public static Long digestHash(byte[] digest, int index) {
            return ((long) (digest[3 + index * 4] & 0xFF) << 24)
                    | ((long) (digest[2 + index * 4] & 0xFF) << 16)
                    | ((long) (digest[1 + index * 4] & 0xFF) << 8)
                    | (digest[index * 4] & 0xFF);
        }

        /** Truncate to 32-bits **/
        public static long hash(final String value) {
            final byte[] bKey = computeMd5(value);
            final long rv = ((long) (bKey[3] & 0xFF) << 24)
                    | ((long) (bKey[2] & 0xFF) << 16)
                    | ((long) (bKey[1] & 0xFF) << 8)
                    | (bKey[0] & 0xFF);
            return rv & 0xffffffffL;
        }
    }
}
