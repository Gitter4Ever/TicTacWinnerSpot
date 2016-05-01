import java.util.*;
public class TicTacWinner extends ArrayIndexOutOfBoundsException {
	public static void main(String[] args) {
		int row = 3, col = 3;
		Scanner ss =new Scanner(System.in);
		System.out.println("Lets play Tic Tac !!!");
		System.out.println("Enter 0 r 1 nine times please !!! :) ");
		int[][] tt = new int[row][col];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tt[i][j] = ss.nextInt(); 
			}
		} 
	for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(tt[i][j]+"  " );
			}
	}
		TicTacWinner ww = new TicTacWinner();
		ww.placeTicTac(tt ,row, col);
	}

	private void placeTicTac(int ticTac[][], int row, int col) {		
	//	int[][] ticTac = { { 1, 0, 1 }, { 0, 1, 0 }, {1, 0, 1} };
		System.out.println();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(" "+ ticTac[i][j] + " " + "   ");
			}
		}
		System.out.println("  ");
		 
		String vertical = findSolVertical(ticTac,row,col);
		System.out.println( "vertical : "+vertical);
		
		
		String horizontal = findSolHorizontal(ticTac, row, col);
		System.out.println( "horizontal " + horizontal);
		
		//now diagonal
		
		String diagonally = findDiagonal(ticTac, row, col);
     	System.out.println("diagonally : "+ diagonally);
}

	private String findDiagonal(int[][] ticTac, int row, int col) {
		String dia1 = findDia1(ticTac, row, col);
		String dia2 = findDia2(ticTac, row, col);
		if(dia1 !=null){
			return dia1;
		}else if(dia2 !=null){
			return dia2;
		}else 
			return null;
	}
 
	private String findDia2(int[][] ticTac, int row, int col) {
		String dia2One = null;
		String dia2Zero = null;
		try {
			for (int i = 0; i <row; i++) { //pp
				for (int j = 0;j< col;j++) {           //pp
						if (ticTac[i][j+2] == 1) {
							if(ticTac[i+1][j+1] ==1){
								if(ticTac[i+2][j] ==1)
							
									dia2One = "Diagonal2 Sol for 1 :  " + i+ "" + (j+2)+ "  " + (i +1) + "" + (j+1) + " "+ (i+2) + "" + j;
									return dia2One;
								}
							}
						else if(ticTac[i][j+2] == 0) {
								if(ticTac[i+1][j+1] ==0){
									if(ticTac[i+2][j] ==0)
								
										dia2Zero = "Diagonal2 Sol for 0 :  "+ i+ "" + (j+2)+ "  " + (i +1) + "" + (j+1) + " "+ (i+2) + "" + j;
										return dia2Zero;
						}
						} //else if ends here
						
					}
				}
			}
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return null;
	}


	private String findDia1(int[][] ticTac, int row, int col) {
		String dia1One = null;
		String dia1Zero = null;
		try {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j <col ; j++) {
					if(i == j){
						if (ticTac[i][j] == 1) {
							if(ticTac[i+1][j+1] ==1){
								if(ticTac[i+2][j+2] ==1)
							
									dia1One = "Diagonal1 Sol for 1 :  " + i + "" + j+ "  " + (i + 1) + "" + (j+1) + " "+ (i + 2) + "" + (j+2);
									return dia1One;
								}
							}else if(ticTac[i][j] ==0){
									if(ticTac[i+1][j+1] ==0){
										if(ticTac[i+2][j+2] ==0)
									
											dia1Zero = "Diagonal1 Sol for 1 :  " + i + "" + j+ "  " + (i + 1) + "" + (j+1) + " "+ (i + 2) + "" + (j+2);
											return dia1Zero;
							}
						}
						
					}
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String findSolVertical(int[][] ticTac, int row, int col) {
		String win1 = null;
		String win2 =null;	
		win1 = oneVert(ticTac, row, col);
		win2 = zeroVert(ticTac, row, col);
		if(win1 !=null ){
			return win1;	
		}else if( win2 != null){
			return win2;}
		else {
			return null;
		}
		
		}
	private String oneVert(int[][] ticTac, int row, int col){

		String verti = null;
		try {
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < col; j++) {
					if (ticTac[i][j] == 1) {
						if (ticTac[i + 1][j] == 1) {
							if (ticTac[i + 2][j] == 1) {
								verti = "Vertical Sol for 1 :  " + i + "" + j+ "  " + (i + 1) + "" + j + " "+ (i + 2) + "" + j;
								return verti;
							}
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return verti;

	}
		
	private String zeroVert(int[][] ticTac, int row, int col){

		String verti = null;
		try {
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < col; j++) {
					if (ticTac[i][j] == 0) {
						if (ticTac[i + 1][j] == 0) {
							if (ticTac[i + 2][j] == 0) {
								verti = "Vertical Sol for 0 :  " + i + "" + j+ "  " + (i + 1) + "" + j + " "+ (i + 2) + "" + j;
								return verti;
							}
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return verti;

	}
	

	private String findSolHorizontal(int[][] ticTac, int row, int col) {
		String winz1 = findZeroH(ticTac,row,col);
		String winz2 = findOneH(ticTac,row,col);
		if(winz1 != null){
			return winz1;
		}else if (winz2 !=null){
			return winz2;
		}
		else
		return null;
	}

	private String findOneH(int[][] ticTac, int row, int col){
		String winSol = null;
		try {
			for (int i = 0; i < row; i++) {
				for (int j = 0;j<=i;j++ ) {
					if (ticTac[i][j] == 1) {
						if (ticTac[i][j+1] == 1) {
							if (ticTac[i][j+2] == 1) {
								winSol = "winner 1 at positions : " + i + j	+ " " + i + "" + (j + 1) + " " + i + ""+ (j + 2);
								return winSol;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return winSol;

	}

	private String findZeroH(int[][] ticTac, int row, int col){  // ....>>>>>>>>>>>>>>>>>>>>>>>>>
		String winSol = null;
			try {
				for (int i = 0; i < row; i++) {
					for (int j = 0;j<=i;j++ ) {
						if (ticTac[i][j] == 0) {
							if (ticTac[i][j+1] == 0) {
								if (ticTac[i][j+2] == 0) {
									winSol = "winner 0 at positions : " + i + j	+ " " + i + "" + (j + 1) + " " + i + ""+ (j + 2);
									return winSol;				}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return winSol;
	}
}
