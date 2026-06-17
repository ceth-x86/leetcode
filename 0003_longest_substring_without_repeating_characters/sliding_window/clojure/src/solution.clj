(ns solution)

(defn length-of-longest-substring [s]
  (:best
   (reduce
    (fn [{:keys [left best last-seen]} [right ch]]
      (let [previous (get last-seen ch)
            left' (if (and previous (>= previous left))
                    (inc previous)
                    left)
            best' (max best (inc (- right left')))]
        {:left left'
         :best best'
         :last-seen (assoc last-seen ch right)}))
    {:left 0 :best 0 :last-seen {}}
    (map-indexed vector s))))
