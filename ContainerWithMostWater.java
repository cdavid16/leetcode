class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length<2)
            throw new IllegalArgumentException("Array size must be at least 2.");
        
        int max = -1;
        for(int i = 0; i<height.length-1;i++){
            for(int j = i+1; j<height.length; j++){
                int area = ((height[i]<height[j]?height[i]:height[j])*Math.abs(i-j));
                if(area>max)
                    max = area;
            }
        }
        return max;
    }

}
