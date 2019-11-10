class ZigZagConversion{
	public String convert(String s, int numRows) {
        
        if(numRows<=1 || numRows > s.length())
            return s;
        
		int maxCols = Math.round(s.length()/2) + 1;
		char[][] nS = new char[numRows][maxCols];
		String ns = "";
		int x=0, y=-1;
		boolean addCol = false;
		boolean addRow = false;
		for(int i = 0; i<s.length(); i++) {
			if(y<numRows-1) {				
				if(y<=0) {
					addRow = true;
					addCol = !addRow;
				}
				
				if(addRow) {
					y++;
				} 
			}else {
				if(addRow) {
					addCol = true;
					addRow = !addCol;						
				}
			}		
			
			if(addCol) {
				x++;
				y--;
			}
			nS[y][x] = s.charAt(i);
		}		
		
		for(int i=0; i<nS.length; i++) {
			for(int j=0;j<nS[i].length; j++) {
				if(nS[i][j] != 0) {
					ns += String.valueOf(nS[i][j]); 
				}
			}
		}		
		
		return ns;
	}
}
