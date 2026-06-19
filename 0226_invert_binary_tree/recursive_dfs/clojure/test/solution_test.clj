(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [invert-tree]]))

(defn build-tree [values]
  (letfn [(build [index]
            (when-let [value (get values index)]
              {:val value
               :left (build (inc (* 2 index)))
               :right (build (+ 2 (* 2 index)))}))]
    (build 0)))

(defn serialize [root]
  (if (nil? root)
    []
    (loop [queue [root]
           result []]
      (if (empty? queue)
        (vec (reverse (drop-while nil? (reverse result))))
        (let [node (first queue)]
          (if (nil? node)
            (recur (subvec (vec queue) 1) (conj result nil))
            (recur (conj (subvec (vec queue) 1) (:left node) (:right node))
                   (conj result (:val node)))))))))

(deftest invert-tree-test
  (testing "examples"
    (is (= [4 7 2 9 6 3 1]
           (serialize (invert-tree (build-tree [4 2 7 1 3 6 9])))))
    (is (= [2 3 1]
           (serialize (invert-tree (build-tree [2 1 3])))))
    (is (= []
           (serialize (invert-tree (build-tree []))))))
  (testing "edge cases"
    (is (= [1]
           (serialize (invert-tree (build-tree [1])))))
    (is (= [1 nil 2]
           (serialize (invert-tree (build-tree [1 2])))))
    (is (= [1 2]
           (serialize (invert-tree (build-tree [1 nil 2])))))
    (is (= [-1 3 -2]
           (serialize (invert-tree (build-tree [-1 -2 3])))))))
