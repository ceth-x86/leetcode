(ns solution)

(defn pop-expired [dq left-bound]
  (if (and (seq dq) (<= (first dq) left-bound))
    (subvec dq 1)
    dq))

(defn pop-smaller-from-back [dq nums value]
  (loop [current dq]
    (if (and (seq current)
             (<= (nth nums (peek current)) value))
      (recur (pop current))
      current)))

(defn max-sliding-window [nums k]
  (loop [i 0
         dq []
         result []]
    (if (= i (count nums))
      result
      (let [dq1 (pop-expired dq (- i k))
            dq2 (pop-smaller-from-back dq1 nums (nth nums i))
            dq3 (conj dq2 i)
            result2 (if (>= i (dec k))
                      (conj result (nth nums (first dq3)))
                      result)]
        (recur (inc i) dq3 result2)))))
