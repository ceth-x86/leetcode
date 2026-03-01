(ns solution-followup
  (:import [java.util Collections]))

(defn build-index-map
  "Preprocess t into a map of char -> sorted vector of indices."
  [t]
  (reduce-kv
   (fn [m i ch] (update m ch (fnil conj []) i))
   {}
   (vec t)))

(defn- bisect-left
  "Find the first index in sorted coll where value >= target."
  [coll target]
  (let [idx (Collections/binarySearch coll (int target))]
    (if (neg? idx)
      (- (inc idx))  ; insertion point
      idx)))

(defn is-subsequence-followup
  "Check if s is a subsequence using precomputed index-map."
  [index-map s]
  (loop [pos 0
         chars (seq s)]
    (if (nil? chars)
      true
      (let [ch (first chars)
            indices (get index-map ch)]
        (if (nil? indices)
          false
          (let [idx (bisect-left indices pos)]
            (if (>= idx (count indices))
              false
              (recur (inc (nth indices idx)) (next chars)))))))))
