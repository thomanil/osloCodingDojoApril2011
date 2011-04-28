


data Tree a = Node a [Tree a]

testTree =
    Node "parent" [
              Node "child 1" [],
              Node "child 2" [
                        Node "GrandChild 1" [],
                        Node "GrandChild 2" []]]

myShow indent (Node content children) =
    foldl
    (++)
    (indent ++ (show content) ++ "\n")
    (map (myShow (indent ++ "\t")) children)

instance Show a => Show (Tree a) where
    show = myShow ""

