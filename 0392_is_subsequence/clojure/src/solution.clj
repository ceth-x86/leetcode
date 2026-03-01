(ns solution)

(defn is-subsequence [s t]
  (loop [i 0
         j 0]
    (cond
      (>= i (count s)) true
      (>= j (count t)) false
      (= (nth s i) (nth t j)) (recur (inc i) (inc j))
      :else (recur i (inc j)))))
