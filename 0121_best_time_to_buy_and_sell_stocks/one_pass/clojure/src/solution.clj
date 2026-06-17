(ns solution)

(defn max-profit [prices]
  (second
   (reduce
    (fn [[min-price best-profit] price]
      [(min min-price price)
       (max best-profit (- price min-price))])
    [(first prices) 0]
    prices)))
