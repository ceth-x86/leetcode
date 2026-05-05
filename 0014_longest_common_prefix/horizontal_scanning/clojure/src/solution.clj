(ns solution
  (:require [clojure.string :as str]))

(defn longest-common-prefix [strs]
  (if (empty? strs)
    ""
    (reduce (fn [prefix s]
              (loop [p prefix]
                (if (str/starts-with? s p)
                  p
                  (if (empty? p)
                    ""
                    (recur (subs p 0 (dec (count p))))))))
            (first strs)
            (rest strs))))
