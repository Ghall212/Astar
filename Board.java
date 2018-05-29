import java.util.*;

public class Board {
	final static int ROW = 15;
	final static int COLUMN = 15;
	
	Scanner kb = new Scanner(System.in);
	int startRow, startColumn, goalRow, goalColumn;
	double numBlocked = ROW * COLUMN * 0.1;
	Node[][] board;
	
	public Board() {
		startRow = startColumn = goalRow = goalColumn = 0;
		numBlocked = 0;
		board = new Node[ROW][COLUMN];
	}
	
	public Board(int startRow, int startColumn, int goalRow, int goalColumn, double numBlocked) {
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.goalRow = goalRow;
		this.goalColumn = goalColumn;
		this.numBlocked = (int)numBlocked;
		//board = new Node[ROW][COLUMN];
	}
	
	public Node[][] getBoard() {
		return this.board;
	}
	
	public void showInitialBoard(int numBlocked) {
		Random rand = new Random();
		int rNumI, rNumJ;
		
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				board[i][j] = new Node(i, j);
				board[i][j].setHCost(Math.abs(i-goalRow)+Math.abs(j-goalColumn));
				board[i][j].setIsBlocked(false);
				board[i][j].setValue("-");
			}
		}
		
		for(int i = 0; i<numBlocked; i++) {
			rNumI = rand.nextInt(ROW);
			rNumJ = rand.nextInt(COLUMN);
			
			if (board[rNumI][rNumJ].getValue().equals("-")) {
				board[rNumI][rNumJ].setValue("#");
				board[rNumI][rNumJ].setIsBlocked(true);
			}
			
			else
				i--;
		}
		
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				System.out.print(board[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
	
	public void showNewBoard(int startRow, int startColumn, int goalRow, int goalColumn) {
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				if(i == startRow && j == startColumn) {
					board[i][j].setValue("S");
				}
				else if(i == goalRow && j == goalColumn) {
					board[i][j].setValue("G");
				}
			}
		}
		
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				System.out.print(board[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
	
	public boolean checkBoard(int row, int column) {
		boolean flag;
		if(board[row][column].getValue().equals("#"))
			flag = false;
		else
			flag = true;
		return flag;
	}
}
