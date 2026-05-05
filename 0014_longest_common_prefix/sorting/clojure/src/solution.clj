(ns solution)

(defn longest-common-prefix [strs]
  (if (empty? strs)
    ""
    (let [sorted (sort strs)
          first-s (first sorted)
          last-s (last sorted)]
      (loop [i 0]
        (if (and (< i (count first-s))
                 (< i (count last-s))
                 (= (nth first-s i) (nth last-s i)))
          (recur (inc i))
          (subs first-s 0 i))))))
