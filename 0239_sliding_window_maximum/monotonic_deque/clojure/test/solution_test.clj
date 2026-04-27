(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [max-sliding-window]]))

(deftest max-sliding-window-test
  (testing "example one"
    (is (= [3 3 5 5 6 7]
           (max-sliding-window [1 3 -1 -3 5 3 6 7] 3))))
  (testing "example two"
    (is (= [1]
           (max-sliding-window [1] 1))))
  (testing "full array"
    (is (= [3]
           (max-sliding-window [2 1 3] 3))))
  (testing "increasing"
    (is (= [2 3 4]
           (max-sliding-window [1 2 3 4] 2))))
  (testing "duplicates"
    (is (= [3 3 3]
           (max-sliding-window [1 3 3 2] 2))))
  (testing "negative values"
    (is (= [-2 -2 -1]
           (max-sliding-window [-4 -2 -5 -1] 2)))))
