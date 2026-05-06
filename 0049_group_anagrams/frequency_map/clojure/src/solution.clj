(ns solution)

(defn char-counts [s]
  (reduce (fn [counts char]
            (update counts char (fnil inc 0)))
          {}
          s))

(defn group-anagrams [strs]
  (vals (group-by char-counts strs)))
