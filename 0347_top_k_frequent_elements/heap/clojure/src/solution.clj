(ns solution
  (:import (java.util PriorityQueue Comparator)))

(defn top-k-frequent [nums k]
  (let [counts (frequencies nums)
        ;; Min-heap using PriorityQueue and a custom comparator
        pq (PriorityQueue. k (reify Comparator
                               (compare [_ a b]
                                 (compare (get counts a) (get counts b)))))]
    (doseq [num (keys counts)]
      (.offer pq num)
      (when (> (.size pq) k)
        (.poll pq)))
    (into [] pq)))
