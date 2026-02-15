(ns solution)

(defn anagram? [s t]
  (and (= (count s) (count t))
       (= (frequencies s) (frequencies t))))
