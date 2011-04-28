class Node
  def initialize(content)
    @content = content
    @children = []
  end

  def add(child)
    @children << child
  end

  def to_s
    to_string(0)
  end

  def to_string(i)
    result = ''
    i.times { result << ' ' }
    result << @content << "\n"
    @children.each do |child|
      result << child.to_string(i+1)
    end
    result
  end

end