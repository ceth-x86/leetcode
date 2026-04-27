(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [first-stable-index]]))

(deftest first-stable-index-test
  (testing "example 1"
    (is (= 3 (first-stable-index [5 0 1 4] 3))))
  (testing "all equal"
    (is (= 0 (first-stable-index [4 4 4] 0))))
  (testing "single element"
    (is (= 0 (first-stable-index [9] 0))))
  (testing "first index stable"
    (is (= 0 (first-stable-index [2 5 7] 0))))
  (testing "no stable index"
    (is (= -1 (first-stable-index [10 0] 5))))
  (testing "strict threshold miss"
    (is (= -1 (first-stable-index [3 1 2] 0))))
  (testing "middle index stable"
    (is (= 2 (first-stable-index [8 2 6 7] 2))))
  (testing "stable at zero"
    (is (= 0 (first-stable-index [1 3 2 5] 1)))))
