(ns solution)

(defn max-heap []
  (java.util.PriorityQueue.
   11
   (reify java.util.Comparator
     (compare [_ a b]
       (let [[va ia] a
             [vb ib] b]
         (if (= va vb)
           (compare ib ia)
           (compare vb va)))))))

(defn discard-stale! [pq left-bound]
  (loop []
    (when-let [[_ idx] (.peek pq)]
      (when (<= idx left-bound)
        (.poll pq)
        (recur)))))

(defn max-sliding-window [nums k]
  (let [pq (max-heap)]
    (loop [i 0
           result []]
      (if (= i (count nums))
        result
        (do
          (.offer pq [(nth nums i) i])
          (discard-stale! pq (- i k))
          (recur (inc i)
                 (if (>= i (dec k))
                   (conj result (first (.peek pq)))
                   result)))))))
