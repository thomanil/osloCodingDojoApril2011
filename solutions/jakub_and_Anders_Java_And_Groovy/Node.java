package scotsman;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private String content;

	private List<Node> children;

	public Node(String content) {
		this(content, new LinkedList<Node>());
	}

	public Node(String content, List<Node> children) {
		this.content = content;
		this.children = children;
	}

	@Override
	public String toString() {
		return toString("");
	}

	private String toString(final String indentation) {
		return indentation + content + "\n" + printList(indentation + "\t", new LinkedList<Node>(children));
	}

	private String printList(String indentation, LinkedList<Node> children) {
		if (children.isEmpty()) return "";
		return children.pop().toString(indentation) + printList(indentation, children);
	}

	public Node withChild(Node child) {
		children.add(child);
		return this;
	}

}
