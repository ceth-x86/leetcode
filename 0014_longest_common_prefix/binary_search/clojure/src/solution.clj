(ns solution
  (:require [clojure.string :as str]))

(defn is-common-prefix? [strs len]
  (let [prefix (subs (first strs) 0 len)]
    (every? #(str/starts-with? % prefix) (rest strs))))

(defn longest-common-prefix [strs]
  (if (empty? strs)
    ""
    (let [min-len (apply min (map count strs))]
      (loop [low 1
             high min-len
             ans 0]
        (if (<= low high)
          (let [mid (quot (+ low high) 2)]
            (if (is-common-prefix? strs mid)
              (recur (inc mid) high mid)
              (recur low (dec mid) ans)))
          (subs (first strs) 0 ans))))))
