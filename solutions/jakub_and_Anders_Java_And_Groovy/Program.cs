using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// email to : thomanil@gmail.com

namespace StatelessTree
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(
                (new Node("parent"))
                .withChild(
                    (new Node("child1"))
                    .withChild(new Node("child1grandchild1"))
                    .withChild(new Node("child1grandchild2")))
                .withChild(
                    (new Node("child2"))
                    .withChild(new Node("child2grandchild1"))
                    .withChild(new Node("child2grandchild2"))
                ));

            // Keep window open
            Console.ReadLine();
        }
    }

    class Node
    {
        private const string SINGLEINDENT = "\t";

        private string content;
        private List<Node> children;

        public Node(string content, List<Node> children = null)
        {
            this.content = content;
            this.children = children ?? new List<Node>();
        }

        public Node withChild(Node child)
        {
            children.Add(child);
            return this;
        }

        public override string ToString()
        {
            return this.ToString(string.Empty);
        }

        private string ToString(string indent)
        {
            return indent + content + "\n" +
                children.Aggregate<Node, string>(string.Empty, (s, n) => s + n.ToString(indent + SINGLEINDENT));
        }
    }
}
