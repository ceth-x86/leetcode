(ns solution)

(def window-size 10)
(def encode {\A 0 \C 1 \G 2 \T 3})

(defn build-first-window [nums]
  (reduce (fn [bitmask value]
            (bit-or (bit-shift-left bitmask 2) value))
          0
          (take window-size nums)))

(defn find-repeated-dna-sequences [s]
  (let [n (count s)]
    (if (<= n window-size)
      []
      (let [nums (mapv encode s)]
        (loop [start 0
               bitmask 0
               seen #{}
               output #{}]
          (if (> start (- n window-size))
            (vec output)
            (let [next-bitmask (if (zero? start)
                                 (build-first-window nums)
                                 (-> bitmask
                                     (bit-shift-left 2)
                                     (bit-or (nums (+ start window-size -1)))
                                     (bit-and (bit-not (bit-shift-left 3 (* 2 window-size))))))]
              (if (contains? seen next-bitmask)
                (recur (inc start)
                       next-bitmask
                       seen
                       (conj output (subs s start (+ start window-size))))
                (recur (inc start)
                       next-bitmask
                       (conj seen next-bitmask)
                       output)))))))))
