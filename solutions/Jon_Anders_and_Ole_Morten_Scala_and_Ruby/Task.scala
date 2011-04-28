object Trees extends Application {

  case class Node(content:String, children:Node*)

  val tree =
    Node("parent",
      Node("child1"),
      Node("child2",
        Node("grandchild1"),
        Node("grandchild2")))

  def toString(node:Node) = {
    def toString(indent:Int, node:Node):String =
      ("\t" * indent) + node.content + "\n" + node.children.map(c => toString(indent + 1, c)).mkString
    toString(0, node)
  }

  println(toString(tree))
}