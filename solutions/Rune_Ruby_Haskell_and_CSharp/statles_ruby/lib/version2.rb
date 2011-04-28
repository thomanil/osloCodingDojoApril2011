class Node
  def initialize(content)
    @content = content
    @children = []
  end

  def add(child)
    @children << child
  end

  def to_s
    to_string("")
  end

  def to_string(indent)
    @children
      .map { |child| child.to_string(indent + " ") }
      .reduce(indent + @content + "\n", :<< )
  end
end