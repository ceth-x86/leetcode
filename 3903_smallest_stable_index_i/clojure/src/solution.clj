(ns solution)

(defn first-stable-index [nums k]
  (let [n (count nums)
        suffix-min-reversed
        (loop [i (- n 2)
               acc [(nums (dec n))]]
          (if (neg? i)
            acc
            (recur (dec i) (conj acc (min (peek acc) (nums i))))))
        suffix-min (vec (reverse suffix-min-reversed))]
    (loop [i 0
           prefix-max (nums 0)]
      (cond
        (= i n) -1
        :else
        (let [next-prefix-max (max prefix-max (nums i))]
          (if (<= (- next-prefix-max (suffix-min i)) k)
            i
            (recur (inc i) next-prefix-max)))))))
