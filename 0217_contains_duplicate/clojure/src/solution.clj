(ns solution)

(defn contains-duplicate? [nums]
  (not= (count nums)
        (count (set nums))))
