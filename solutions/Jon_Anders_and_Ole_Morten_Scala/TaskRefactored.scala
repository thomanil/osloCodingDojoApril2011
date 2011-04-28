case class Node(content:String, children:Node*)

object Trees extends Application {

 def toString(node:Node, indentchar:String = "\t") = {
   def toString(indent:Int, node:Node):String =
     (indentchar * indent) + node.content + "\n" + node.children.map(c => toString(indent + 1, c)).mkString
   toString(0, node)
 }
}

val tree =
   Node("parent",
     Node("child1"),
     Node("child2",
       Node("grandchild1"),
       Node("grandchild2")))

val ind = Console.readLine("Skriv inn indentering som vil brukes (du får ikke se det mens du skriver for scala folka har skjønt at det er sløs å bruke tid på det). Skriv nå og trykk enter: ")
println(Trees.toString(tree, ind))