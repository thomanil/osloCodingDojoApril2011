package no.cicero.dojo;

import com.sun.tools.internal.xjc.model.nav.EagerNClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Carl-Erik Kopseng
 * Date: 28.04.11
 * Purpose:
 */
public class Node {
	private String content;
	private List<Node> children;


	public static void main(String arguments[]) {
		/* Building node hierarchy */
		Node root = new Node("root");
		Node child1 = new Node("child1");
		Node child2 = new Node("child2");
		root.add(child1);
		root.add(child2);

		Node grandchild2_1 = new Node("grandchild2_1");
		Node grandchild2_2 = new Node("grandchild2_2");
		child2.add(grandchild2_1);
		child2.add(grandchild2_2);

		Node babychild2_1_1 = new Node("babychild2_1_1");
		grandchild2_1.add(babychild2_1_1);

		/* Print nodes */
		System.out.println(root.toString());
	}

	public Node(String content) {
		this.content = content;
		this.children = new ArrayList<Node>();
	}

	public void add(Node child) {
		children.add(child);
	}


	public String toString() {
		return tabbedString2("");
	}

	public String tabbedString1(int level) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < level; i++) {
			sb.append("\t");
		}

		sb.append(content);
		sb.append("\n");

		for (Node c : children) {
			sb.append(c.tabbedString1(level + 1));
		}

		return sb.toString();
	}

	public String tabbedString2(String indentation) {
		String childTree = "";
		for (Node child : children) {
			childTree += child.tabbedString2(indentation + "\t");
		}

		return indentation + content + "\n" + childTree;
	}

	/*
	public String tabbedString3(String indentation) {

		return indentation + content + "\n" +
				reduce(
						map(children, new Function() {
							public Object exec(Object content) {
								return new Object();
							}
						}),
						new ReduceFunction() {
								public Object exec(content) {


		}
						}))
				;
	}
	*/

	private List map(List elems, Function function) {
		List returnList = new ArrayList();

		for (Object elem : elems) {
			returnList.add(function.exec(elem));
		}

		return returnList;
	}

	private Object reduce(List elems, Function function) {return  null;}  ;
}

/* Husker ikke hvordan vi skulle gj?re dette vha Generics ... */
interface Function {
	public Object exec(Object o);
}

interface ReduceFunction {
	public Object exec(List o);
}

