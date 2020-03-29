package leetcode.algorithms;
class RemoveDuplicatesFromSortedArray{
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;

        int i=0, j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return ++i;
    }
}
