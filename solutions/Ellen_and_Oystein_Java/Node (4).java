package xpmeetup;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String content = "parent";
	private List<Node> children = new ArrayList<Node>();
	
	public Node(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		String output = "";
		for (Node child : children) {
			output += child.toString(1);
		}
		return output.isEmpty() ? content : content + output;
	}
	
	private String toString(int level) {
		String output = "\n";
		for(int i = 0; i<level; i++){
			output += "\t";
		}
		output += content;
		for (Node child : children) {
			output += child.toString(level +1);
		}
		return output;
	}

	public void addChild(Node child) {
		children.add(child);
	}
}
