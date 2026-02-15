(ns solution)

(defn two-sum [nums target]
  (loop [i 0
         seen {}]
    (when (< i (count nums))
      (let [num (nth nums i)
            complement (- target num)]
        (if (contains? seen complement)
          [(seen complement) i]
          (recur (inc i) (assoc seen num i)))))))
