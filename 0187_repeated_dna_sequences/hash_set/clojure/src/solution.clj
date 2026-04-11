(ns solution)

(def window-size 10)

(defn find-repeated-dna-sequences [s]
  (if (< (count s) window-size)
    []
    (loop [start 0
           seen #{}
           repeated #{}
           result []]
      (if (> (+ start window-size) (count s))
        result
        (let [fragment (subs s start (+ start window-size))]
          (cond
            (contains? repeated fragment)
            (recur (inc start) seen repeated result)

            (contains? seen fragment)
            (recur (inc start) seen (conj repeated fragment) (conj result fragment))

            :else
            (recur (inc start) (conj seen fragment) repeated result)))))))
