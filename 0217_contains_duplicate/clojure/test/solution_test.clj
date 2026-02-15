(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [contains-duplicate?]]))

(deftest contains-duplicate-test
  (testing "has duplicate"
    (is (true? (contains-duplicate? [1 2 3 1]))))
  (testing "all distinct"
    (is (false? (contains-duplicate? [1 2 3 4]))))
  (testing "multiple dupes"
    (is (true? (contains-duplicate? [1 1 1 3 3 4 3 2 4 2]))))
  (testing "single element"
    (is (false? (contains-duplicate? [1]))))
  (testing "two same"
    (is (true? (contains-duplicate? [1 1]))))
  (testing "two different"
    (is (false? (contains-duplicate? [1 2]))))
  (testing "all same"
    (is (true? (contains-duplicate? [5 5 5 5]))))
  (testing "extreme values"
    (is (false? (contains-duplicate? [-1000000000 1000000000])))))
