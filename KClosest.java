class KClosest{
public int[][] kClosest(int[][] points, int K) {
		if(K==0 || points.length==0)
			return null;
		
		TreeMap<Integer, List<Integer>> mp = new TreeMap<Integer, List<Integer>>();
		int X1 = 0, Y1=0;
		Integer distance=0;
		int carryPoints = 0;
		int[][] closest = new int[K][2];
		
		for(int i=0; i<points.length;i++) {
			distance = (int)(Math.pow(X1-points[i][0], 2) + Math.pow(Y1-points[i][1], 2));
			if(mp.containsKey(distance)) 
				mp.get(distance).add(i);			
			else {
				List<Integer> tmp = new LinkedList<Integer>();
				tmp.add(i);
				mp.put(distance, tmp);
			}
		}
		
		for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
			
			for(Integer element : entry.getValue()) {
				if(carryPoints==K)
					return closest;
				
				closest[carryPoints++] = points[element];
			}			
		}
		
		return points;
        
    }	
}
