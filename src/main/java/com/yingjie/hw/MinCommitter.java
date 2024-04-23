package com.yingjie.hw;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个二维数组files = [[5],[0],[0,2]]，
 * files[0]代表文件0需要5号committer审核，
 * files[2]代表需要0或2号中的一位committer审核，
 * 求最少需要几位committer
 */
public class MinCommitter {

    public static void main(String[] args) {
        MinCommitter solution = new MinCommitter();
        solution.minCommitter(new int[][]{{1,3},{2,1},{1,9,3}});
    }

    private Set<Integer> committers = new HashSet<>();

    private Integer result = Integer.MAX_VALUE;

    public int minCommitter(int[][] files) {
        if (files.length == 0) {
            return 0;
        }
        dfsHelper(0, files);
        return result;
    }

    public void dfsHelper(int fileId, int[][] files) {
        if (fileId == files.length) {
            result = Math.min(committers.size(), result);
            return;
        }
        for (int i = 0; i < files[fileId].length; i++) {
            int committer = files[fileId][i];
            if (committers.contains(committer)) {
                dfsHelper(fileId + 1, files);
            } else {
                committers.add(committer);
                dfsHelper(fileId + 1, files);
                committers.remove(committer);
            }
        }
    }


}
