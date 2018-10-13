package com.example.demo.java_code.leetcode.n_queens;

import java.util.ArrayList;
import java.util.List;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/10
 * </p>
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            List<String> queen = new ArrayList<>(n);
            queen.add(i + "Q");
        }
        return null;
    }
}
