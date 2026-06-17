(ns solution)

(defn max-profit [prices]
  (let [prefix-min (rest (reductions min (first prices) prices))]
    (apply max 0 (map - prices prefix-min))))
