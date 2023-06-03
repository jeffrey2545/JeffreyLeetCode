class SparseVector {
    
    int[] initVec;
    
    SparseVector(int[] nums) {
        initVec = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for (int i = 0; i < initVec.length; i++) {
            ans = ans + (initVec[i] * vec.initVec[i]);
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);