class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length<=1)
            return (nums.length==0?0:nums[0]==val?0:1) ;
        
        int i=0,j=0;
        do{
            while (nums[i]==val){
                i++;
                if(i==nums.length)
                    return j;
            }
            nums[j]=nums[i];
            j++;
        }while (++i<nums.length);

        return j;
    }
}
