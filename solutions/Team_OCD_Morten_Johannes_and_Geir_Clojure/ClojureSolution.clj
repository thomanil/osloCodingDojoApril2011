;; Her er det første fungerende resultatet vi endte opp med:

(ns stateless
  (:use [clojure.test]))

(defn print-subtree [subtree prefix]
  (if (empty? subtree)
    ""
    (apply str prefix (first subtree) "\n"
           (map #(print-subtree %1 (str "\t" prefix)) (rest subtree)))))

(defn print-tree [tree]
  (print-subtree tree ""))

(deftest print-empty-tree
  (is (= (print-tree nil) ""))
  (is (= (print-tree '()) ""))
  (is (= (print-tree '("a")) "a\n"))
  (is (= (print-tree '("a" ("b"))) "a\n\tb\n"))
  (is (= (print-tree '("a" ("b") ("c"))) "a\n\tb\n\tc\n"))
  (is (= (print-tree
          '("parent"
            ("child1")
            ("child2"
             ("grandchild1")
             ("grandchild2"))))
         "parent\n\tchild1\n\tchild2\n\t\tgrandchild1\n\t\tgrandchild2\n")))