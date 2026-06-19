(ns solution)

(defn invert-tree [root]
  (when root
    {:val (:val root)
     :left (invert-tree (:right root))
     :right (invert-tree (:left root))}))
