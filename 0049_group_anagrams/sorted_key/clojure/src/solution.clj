(ns solution)

(defn group-anagrams [strs]
  (vals (group-by sort strs)))
