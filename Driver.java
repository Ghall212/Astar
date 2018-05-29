import java.util.*;

public class Driver {
	
	final static int ROW = 15;
	final static int COLUMN = 15;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int startRow, startColumn, goalRow, goalColumn;
		double numBlocked = ROW * COLUMN * 0.1;
		Board board;
		Astar aStar;
		String reset;
		
		while(true) {
			board = new Board();
			
			System.out.println("This is the initial state of the Board:\n");
			board.showInitialBoard((int)numBlocked+1);
			
			System.out.println("Enter the row you wish to start at (0-14): ");
			startRow = kb.nextInt();
			
			System.out.println("Enter the column you wish to start at (0-14): ");
			startColumn = kb.nextInt();
			
			while (!board.checkBoard(startRow, startColumn)) {
				System.out.println("That space appears to be blocked out. Please try again.");
				
				System.out.println("Enter the row you wish to start at (0-14): ");
				startRow = kb.nextInt();
				
				System.out.println("Enter the column you wish to start at (0-14): ");
				startColumn = kb.nextInt();
			}
			
			System.out.println("Enter the row you wish to end at (0-14): ");
			goalRow = kb.nextInt();
			
			System.out.println("Enter the column you wish to end at (0-14): ");
			goalColumn = kb.nextInt();
			
			while (!board.checkBoard(goalRow, goalColumn)) {
				System.out.println("That space appears to be blocked out. Please try again.");
				
				System.out.println("Enter the row you wish to end at (0-14): ");
				goalRow = kb.nextInt();
				
				System.out.println("Enter the column you wish to end at (0-14): ");
				goalColumn = kb.nextInt();
			}
			
			System.out.println("This is the new state of the board with the information you entered:\n");
			board.showNewBoard(startRow, startColumn, goalRow, goalColumn);
			
			aStar = new Astar(startRow, startColumn, goalRow, goalColumn, board.getBoard());
			
			System.out.println("\nWould you like to have to board reset? enter any key for yes, type No to exit:");
			reset = kb.next();
			
			if(reset.equals("No") || reset.equals("no"))
				break;
		}
		kb.close();
	}
}
