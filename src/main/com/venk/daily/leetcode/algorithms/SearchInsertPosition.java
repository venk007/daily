package com.venk.daily.leetcode.algorithms;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length - 1;
        if (len < 0) {
            return 0;
        }
        if (target > nums[len]) {
            return len;
        }
        int low = 0;
        int high = len;
        int mid;
        while (low <= high){
            mid = (high - low) / 2;
            if (nums[mid] < target){
                low = mid + 1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else return mid;
            System.out.println(String.format("low:%S, mid:%S, high:%S", low, mid, high));
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 8, 9, 10, 11, 17, 19, 23, 31};
        int result = searchInsert(nums, 2);
        System.out.println("result:" + result);
    }

}