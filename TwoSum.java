class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap hash = new HashMap();

        for(int i = 0; i<nums.length;i++)
        {
            hash.put(nums[i], i);
        }

        for(int i = 0; i<nums.length; i++)
        {
            if(hash.containsKey(target-nums[i]) && hash.get(target-nums[i]).hashCode() != i)
                return new int[]{i, hash.get(target-nums[i]).hashCode()};
        }

        return null;
    }
}
