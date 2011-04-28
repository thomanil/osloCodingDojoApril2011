class Node
  def initialize(content, *children)
    @content = content
    @children = children
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