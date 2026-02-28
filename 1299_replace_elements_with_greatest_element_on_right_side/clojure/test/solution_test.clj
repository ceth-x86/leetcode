(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [replace-elements]]))

(deftest replace-elements-test
  (testing "example 1"
    (is (= [18 6 6 6 1 -1] (replace-elements [17 18 5 4 6 1]))))
  (testing "single element"
    (is (= [-1] (replace-elements [400]))))
  (testing "two elements ascending"
    (is (= [5 -1] (replace-elements [1 5]))))
  (testing "descending"
    (is (= [4 3 2 1 -1] (replace-elements [5 4 3 2 1]))))
  (testing "ascending"
    (is (= [5 5 5 5 -1] (replace-elements [1 2 3 4 5]))))
  (testing "all same"
    (is (= [7 7 -1] (replace-elements [7 7 7]))))
  (testing "two elements descending"
    (is (= [1 -1] (replace-elements [5 1]))))
  (testing "large value"
    (is (= [100000 -1] (replace-elements [1 100000])))))
