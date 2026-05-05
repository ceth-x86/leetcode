(ns solution)

(defn longest-common-prefix [strs]
  (if (empty? strs)
    ""
    (let [first-str (first strs)
          others (rest strs)]
      (loop [i 0]
        (if (< i (count first-str))
          (let [char (nth first-str i)]
            (if (every? (fn [s] (and (< i (count s)) (= (nth s i) char))) others)
              (recur (inc i))
              (subs first-str 0 i)))
          first-str)))))
