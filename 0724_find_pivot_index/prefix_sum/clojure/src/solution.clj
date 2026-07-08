(ns solution)

(defn pivot-index [nums]
  (let [total-sum (reduce + nums)]
    (loop [left-sum 0
           idx 0
           [num & remaining] nums]
      (if (nil? num)
        -1
        (if (= left-sum (- total-sum left-sum num))
          idx
          (recur (+ left-sum num) (inc idx) remaining))))))
