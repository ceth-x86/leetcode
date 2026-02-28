(ns solution)

(defn replace-elements [arr]
  (->> arr
       reverse
       (reduce (fn [[result right-max] val]
                 [(cons right-max result) (max right-max val)])
               ['() -1])
       first
       vec))
