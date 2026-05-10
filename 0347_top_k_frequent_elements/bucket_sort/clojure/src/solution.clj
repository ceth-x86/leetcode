(ns solution)

(defn top-k-frequent [nums k]
  (let [counts (frequencies nums)
        max-freq (count nums)
        buckets (reduce (fn [b [num freq]]
                          (update b freq (fnil conj []) num))
                        {}
                        counts)]
    (loop [freq max-freq
           result []]
      (if (or (zero? freq) (= (count result) k))
        result
        (let [items (get buckets freq [])
              needed (- k (count result))
              to-add (take needed items)]
          (recur (dec freq) (into result to-add)))))))
