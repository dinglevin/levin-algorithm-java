package com.dinglevin.algorithm.others;

import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static com.dinglevin.algorithm.common.ListNodeUtils.printList;

import org.junit.Test;

/**
 * 描述：ListReverseTest
 *
 * @author dinglevin
 * @since 2021/6/15 11:02 周二
 */
public class ListReverseTest {
    private ListReverse listReverse = new ListReverse();

    @Test
    public void testExecute() {
        printList(listReverse.execute(buildList("10")));
        printList(listReverse.execute(buildList("10,20")));
        printList(listReverse.execute(buildList("10,20,30,40,50")));
    }
}
