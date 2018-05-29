public class Node {
	int row, column, hCost; 
	int fCost;
	boolean isBlocked;
	String value;
	Node parent;
	
	public Node(int i, int j) {
		this.row = i;
		this.column = j;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	public boolean getIsBlocked() {
		return this.isBlocked;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setFCost(int fCost) {
		this.fCost = fCost;
	}
	
	public int getFCost() {
		return this.fCost;
	}
	
	public void setHCost(int hCost) {
		this.hCost = hCost;
	}
	
	public int getHCost() {
		return this.hCost;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	@Override
	public String toString() {
		return "[" + this.row + ", " + this.column + "]";
	}
}
