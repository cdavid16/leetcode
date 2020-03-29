package leetcode.algorithms;
class PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
        if(N==0 || N>Math.pow(10, 9))
            return cells;
        
        int[] new_day = new int[cells.length];
       
        
        int days = 0;
        java.util.Hashtable<Integer, Object> hs = new java.util.Hashtable<Integer, Object>(); 
        
        do{
        
        	for(int i=1;i<cells.length-1;i++){
                new_day[i]= ((cells[i-1]^cells[i+1]) ^ 1);
            }            
			if(days>0) {
				if(!isInitialState((int[])hs.get(1), new_day)) 
					hs.put(++days, new_day.clone()); 
				else
					break;	
			}
			else
				hs.put(++days, new_day.clone());
			
			cells=new_day.clone();
			
        }while(days<N);
        
		return (int[])hs.get(N%days==0?days:N%days);
    }
	
	private boolean isInitialState(int[] initial, int[] state) {
		for(int i=0; i<initial.length;i++) {
			if(initial[i]!=state[i])
				return false;
		}
		return true;
	}
}
