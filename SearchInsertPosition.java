class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
      return getIndex(nums, 0, nums.length-1, target);
  }

  private int getIndex(int[] nums, int start, int end, int target){
      if(nums[start]>=target)
          return 0;

      if(nums[end]<target)
          return end+1;

      int pivot;
      if(start<end){
          pivot=(end+start)/2;

          if(pivot!= start){
              if(nums[pivot]==target){
                  return pivot;
              }
              else{
                  if(nums[pivot]>target)
                      return getIndex(nums, start, pivot, target);
                  else
                      return getIndex(nums, pivot, end, target);
              }
          }
      }

      return end;
  }
}
