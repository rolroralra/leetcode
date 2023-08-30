class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        if (nums1.length == 0) {
            int midIndex = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                return (double) (nums2[midIndex] + nums2[midIndex - 1]) / 2;
            }

            return nums2[midIndex];
        }

        int totalSize = nums1.length + nums2.length;

        int leftIndex = 0;
        int rightIndex = nums1.length - 1;
        int midIndex = (leftIndex + rightIndex) / 2;
        int size1 = midIndex + 1;
        int halfSize = totalSize / 2;
        int size2 = halfSize - size1;

        boolean isValid = false;
        while (leftIndex <= rightIndex) {
            if (validCheck(size1, size2, nums1, nums2)) {
                isValid = true;
                break;
            }

            if (size2 != nums2.length && nums1[size1 - 1] > nums2[size2]) {
                rightIndex = midIndex - 1;
            }

            if (size1 != nums1.length && nums2[size2 - 1] > nums1[size1]) {
                leftIndex = midIndex + 1;
            }

            midIndex = (leftIndex + rightIndex) / 2;
            size1 = midIndex + 1;
            size2 = halfSize - size1;
        }

        if (!isValid && validCheck(0, halfSize, nums1, nums2)) {
            size1 = 0;
            size2 = halfSize;
        }

        return calcResult(size1, size2, nums1, nums2);
    }

    private boolean validCheck(int size1, int size2, int[] nums1, int[] nums2) {
        boolean valid1 = size2 == nums2.length || size1 == 0 || nums1[size1 - 1] <= nums2[size2];
        boolean valid2 = size1 == nums1.length || size2 == 0 || nums2[size2 - 1] <= nums1[size1];

        return valid1 && valid2;
    }

    private double calcResult(int size1, int size2, int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;

        int resultSum = 0;

        if (size1 == nums1.length) {
            resultSum += nums2[size2];
        } else if (size2 == nums2.length) {
            resultSum += nums1[size1];
        } else {
            resultSum += Math.min(nums1[size1], nums2[size2]);
        }

        if (totalSize % 2 == 0) {
            if (size1 == 0) {
                resultSum += nums2[size2 - 1];
            } else if (size2 == 0) {
                resultSum += nums1[size1 - 1];
            } else {
                resultSum += Math.max(nums1[size1 - 1], nums2[size2 - 1]);
            }
            
            return  ((double) resultSum) / 2;
        }

        return resultSum;
    }
}