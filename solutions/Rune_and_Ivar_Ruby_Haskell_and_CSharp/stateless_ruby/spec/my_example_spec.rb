require "rspec"
require_relative '../lib/node'

describe Node do
  it "show" do
    root = Node.new('root',
      Node.new('child 1'),
      Node.new('child 2',
        Node.new('grandchild 1'),
        Node.new('grandchild 2')
      )
    )
    puts root
  end
end