(ns solution)

(defn insert [trie word]
  (if (empty? word)
    (assoc trie :is-end true)
    (let [char (first word)]
      (update trie char (fn [child]
                          (insert (or child {:is-end false}) (rest word)))))))

(defn child-count [node]
  (count (dissoc node :is-end)))

(defn find-prefix [node]
  (loop [curr node
         prefix ""]
    (if (and (= (child-count curr) 1) (not (:is-end curr)))
      (let [char (first (keys (dissoc curr :is-end)))]
        (recur (get curr char) (str prefix char)))
      prefix)))

(defn longest-common-prefix [strs]
  (if (empty? strs)
    ""
    (if (some empty? strs)
      ""
      (let [trie (reduce insert {:is-end false} strs)]
        (find-prefix trie)))))
