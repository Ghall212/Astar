
import java.util.*;

public class NodeCompare implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		return n1.getFCost()<n2.getFCost()?-1:
            n1.getFCost()>n2.getFCost()?1:0;
	}
}
