(ns solution)

(defn- get-node [tree path]
  (if (empty? path)
    tree
    (get-in tree path)))

(defn- set-node [tree path node]
  (if (empty? path)
    node
    (assoc-in tree path node)))

(defn invert-tree [root]
  (loop [tree root
         queue (if root [[]] [])]
    (if (empty? queue)
      tree
      (let [path (first queue)
            rest-queue (subvec (vec queue) 1)
            node (get-node tree path)]
        (if (nil? node)
          (recur tree rest-queue)
          (let [swapped (assoc node :left (:right node) :right (:left node))
                tree' (set-node tree path swapped)
                left-path (conj path :left)
                right-path (conj path :right)]
            (recur tree' (conj rest-queue left-path right-path))))))))
