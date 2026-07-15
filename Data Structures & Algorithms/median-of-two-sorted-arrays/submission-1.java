class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int half = (A.length + B.length) / 2;
        int left = 0;
        int right = A.length - 1;

        while (true) {
            int i = Math.floorDiv(left + right, 2); // A
            int j = half - i - 2; // B
            int Aleft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int Aright = i + 1 < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int Bright = j + 1 < B.length ? B[j + 1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((A.length + B.length) % 2 == 1) {
                    return Math.min(Aright, Bright);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        
        
    }
}
