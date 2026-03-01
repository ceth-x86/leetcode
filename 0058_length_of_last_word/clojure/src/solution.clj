(ns solution
  (:require [clojure.string :as str]))

(defn length-of-last-word [s]
  (->> (str/trimr s)
       (re-find #"\S+$")
       count))
