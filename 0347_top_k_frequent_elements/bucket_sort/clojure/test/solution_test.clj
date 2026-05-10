(ns solution-test
  (:require [clojure.test :refer :all]
            [solution :refer :all]))

(deftest test-top-k-frequent
  (is (= (set (top-k-frequent [1 1 1 2 2 3] 2)) #{1 2}))
  (is (= (set (top-k-frequent [1] 1)) #{1})))
