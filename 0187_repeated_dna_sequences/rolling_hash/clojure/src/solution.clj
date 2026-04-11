(ns solution)

(def window-size 10)
(def window-mask (dec (bit-shift-left 1 (* 2 window-size))))
(def encode {\A 0 \C 1 \G 2 \T 3})

(defn find-repeated-dna-sequences [s]
  (if (< (count s) window-size)
    []
    (loop [index 0
           rolling 0
           seen #{}
           repeated #{}
           result []]
      (if (= index (count s))
        result
        (let [next-rolling (bit-and window-mask
                                    (bit-or (bit-shift-left rolling 2)
                                            (encode (nth s index))))]
          (if (< index (dec window-size))
            (recur (inc index) next-rolling seen repeated result)
            (let [start (- index (dec window-size))]
              (cond
                (contains? repeated next-rolling)
                (recur (inc index) next-rolling seen repeated result)

                (contains? seen next-rolling)
                (recur (inc index)
                       next-rolling
                       seen
                       (conj repeated next-rolling)
                       (conj result (subs s start (+ start window-size))))

                :else
                (recur (inc index)
                       next-rolling
                       (conj seen next-rolling)
                       repeated
                       result)))))))))
