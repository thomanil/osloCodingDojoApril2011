using System;
using System.Linq;

namespace Tree
{
    class Tree
    {
        private readonly string _contents;
        private readonly Tree[] _children;

        public Tree(string contents, params Tree[] children)
        {
            _contents = contents;
            _children = children;
        }

        public override string ToString()
        {
            return ToString("");
        }

        private string ToString(string indent)
        {
            return
                _children
                .Select(x => x.ToString(indent + "\t"))
                .Aggregate(
                    indent + _contents + Environment.NewLine,
                    (x, y) => x + y);
        }
    }


    class Program
    {
        static void Main()
        {
            var ex = new Tree("parent",
                new Tree("child 1"),
                new Tree("child 2",
                    new Tree("grandchild 1"),
                    new Tree("grandchild 2")));
            Console.WriteLine(ex);
            Console.ReadLine();
        }
    }
}
