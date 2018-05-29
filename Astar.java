import java.util.*;

public class Astar {
	final static int ROW = 15;
	final static int COLUMN = 15;
	Comparator<Node> comparator = new NodeCompare();
	PriorityQueue<Node> open = new PriorityQueue<>(comparator);
	boolean[][] closed = new boolean[ROW][COLUMN];
	
	public Astar(int startRow, int startColumn, int goalRow, int goalColumn, Node[][] board) {
		Node current;
		Node temp;
		
		open.add(board[startRow][startColumn]);
		
		while(true) {
			current = open.poll();
			if(current == null)
				break;
			
			closed[current.getRow()][current.getColumn()] = true;
			
			if(current.equals(board[goalRow][goalColumn])) {
				showBoardPath(startRow, startColumn, goalRow, goalColumn, board);
				return;
			}
				
			
			if(current.getRow() - 1 >= 0) {
			temp = board[current.getRow() - 1][current.getColumn()];
				updateCosts(temp, current, current.getFCost() + 1);
			}
			
			if(current.getColumn() - 1 >= 0) {
				temp = board[current.getRow()][current.getColumn() - 1];
				updateCosts(temp, current, current.getFCost() + 1);
			}
			
			if(current.getColumn() + 1 < board[0].length) {
				temp = board[current.getRow()][current.getColumn() + 1];
				updateCosts(temp, current, current.getFCost() + 1);
			}
			
			if(current.getRow() + 1 < board.length) {
				temp = board[current.getRow() + 1][current.getColumn()];
				updateCosts(temp, current, current.getFCost() + 1);
			}
		}
	}
	
	public void showBoardPath(int startRow, int startColumn, int goalRow, int goalColumn, Node[][] board) {
		if(closed[goalRow][goalColumn]) {
			Node current = board[goalRow][goalColumn];
			System.out.println();
			System.out.print(current);
			while(current.getParent() != null) {
				System.out.print(" <-- " + current.getParent());
				current = current.getParent();
				
				board[current.getRow()][current.getColumn()].setValue("o");
			}
			
			board[startRow][startColumn].setValue("S");
			System.out.println();
			System.out.println();
			
			for(int i = 0; i < ROW; i++) {
				for(int j = 0; j < COLUMN; j++) {
					System.out.print(board[i][j].getValue() + " ");
				}
				System.out.println();
			}
				
			System.out.println();
		}
		else {
			System.out.println("No Possible Path");
		}
	}
	
	public void updateCosts(Node temp, Node current, int cost) {
		if(temp.getIsBlocked() == true || closed[temp.getRow()][temp.getColumn()])
			return;
		
		int tempFinCost = temp.getHCost() + cost;
		
		boolean inOpen = open.contains(temp);
		if(!inOpen || tempFinCost < temp.getFCost()) {
			temp.setFCost(tempFinCost);
			temp.setParent(current);
			if(!inOpen)
				open.add(temp);
		}
	}

}
