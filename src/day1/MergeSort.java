package day1;

import java.util.List;

public class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i=0,j=0 ; i< nums1.length && j< nums2.length ; ){

            if(nums1[i] > nums2[j]){
                int temp ;
                temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                i++;
            }
        }


    }
}
