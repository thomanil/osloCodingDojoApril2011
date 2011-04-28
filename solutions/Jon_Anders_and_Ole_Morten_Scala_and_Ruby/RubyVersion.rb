class Node
  def initialize(content, children = [])
    @content = content
    @children = children
  end
  
  
  def prettyprint(indent = 0)
    pp_child = proc {|c| c.prettyprint(indent+1)}
    "\t"*indent+ @content + "\n"+ @children.map(&pp_child).join("") 
  end
  
end

def node(*args)
  Node.new(*args)
end

root = node("parent",[
  node("child1"), 
  node("child2", [
    node("child2a"), 
    node("child2b")] 
  )]
)

puts root.prettyprint   
