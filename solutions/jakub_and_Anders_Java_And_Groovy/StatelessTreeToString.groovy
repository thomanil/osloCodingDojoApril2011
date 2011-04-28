class Node {
	def content;
	def children = [];
	public Node(String content, List children) {this. content= content; this. children=children;
	}

	public String toString() {
		return toString("");
	}

	private String toString(String tabs) {
		return tabs + content + "\n"
			+ children.inject("") { sum, child -> sum + child.toString(tabs+'\t') }
	}
}

new Node("root",
		[new Node("child1"
				, [new Node("grandchild", [])])
				, new Node("child2",[])])
		.toString();