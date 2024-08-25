package com.dinglevin.algorithm.others;

/**
 * 描述：回文判断
 *
 * @author dinglevin
 * @since 2021/7/16 11:09 周五
 */
public class Palindrome {
    public boolean isTrue(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        return innerIsTrue(0, value);
    }

    private boolean innerIsTrue(int index, String value) {
        if (index == value.length() / 2) {
            return true;
        }

        if (value.charAt(index) != value.charAt(value.length() - 1 - index)) {
            return false;
        }

        return innerIsTrue(index + 1, value);
    }
}
