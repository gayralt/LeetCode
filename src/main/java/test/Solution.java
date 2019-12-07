package main.java.test;

import sun.awt.image.ImageWatched;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new LinkedList<>();
        LinkedList<Integer> newNums=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            newNums.add(nums[i]);
        }
        permuteNums(results,new LinkedList<Integer>(),newNums,nums.length);
        return results;
    }
    private void permuteNums(List<List<Integer>> results,List<Integer> result,List<Integer> nums,int length){
        if (length==result.size()){
            results.add(result);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newNums=new LinkedList<>(nums);
            List<Integer> newResult=new LinkedList<>(result);
            newResult.add(newNums.get(i));
            newNums.remove(i);
            permuteNums(results,newResult,newNums,length);
        }
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.permute(new int[]{1,2,3});
    }
}
