package main.java.sortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QuickSortArray {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result=null;
        if (nums==null||nums.length<=0)
            return result;
        quickSort(nums,nums.length-1,0);
        result=new LinkedList<>();
        for (int num:nums) {
            result.add(num);
        }
        return result;
    }
    private void quickSort(int[] nums,int high,int low){
        if (low>=high)
            return;
        int l=low;
        int r=high;
        int temp=nums[l];
        while (l<r){
            //左挖洞 找右的填坑
            while (l<r&&nums[r]>=temp){
                r--;
            }
            nums[l]=nums[r];
            //右挖洞，找左的填坑
            while (l<r&&nums[l]<=temp){
                l++;
            }
            nums[r]=nums[l];
        }
        nums[l]=temp;
        quickSort(nums,high,l+1);
        quickSort(nums,l-1,low);
    }

    public static void main(String[] args) {
        QuickSortArray array=new QuickSortArray();
        array.sortArray(new int[]{3,4,2,1,5,5,9,8,7});
    }
}
