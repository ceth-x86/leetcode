(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [two-sum]]))

(deftest two-sum-test
  (testing "pair at start"
    (is (= [0 1] (two-sum [2 7 11 15] 9))))
  (testing "pair in middle"
    (is (= [1 2] (two-sum [3 2 4] 6))))
  (testing "same elements"
    (is (= [0 1] (two-sum [3 3] 6))))
  (testing "pair at end"
    (is (= [2 3] (two-sum [1 2 3 4] 7))))
  (testing "negative numbers"
    (is (= [2 4] (two-sum [-1 -2 -3 -4 -5] -8))))
  (testing "zeros"
    (is (= [0 3] (two-sum [0 4 3 0] 0))))
  (testing "extreme values"
    (is (= [0 1] (two-sum [-1000000000 1000000000] 0))))
  (testing "duplicate values"
    (is (= [1 2] (two-sum [1 5 5 11] 10)))))
