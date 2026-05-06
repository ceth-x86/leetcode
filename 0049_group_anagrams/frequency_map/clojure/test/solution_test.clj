(ns solution-test
  (:require [clojure.test :refer :all]
            [solution :refer :all]))

(deftest test-group-anagrams
  (let [result (group-anagrams ["eat" "tea" "tan" "ate" "nat" "bat"])]
    (is (= (count result) 3))))
