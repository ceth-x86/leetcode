(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [max-profit]]))

(deftest max-profit-test
  (testing "profitable swing"
    (is (= 5 (max-profit [7 1 5 3 6 4]))))
  (testing "decreasing prices"
    (is (= 0 (max-profit [7 6 4 3 1]))))
  (testing "single price"
    (is (= 0 (max-profit [5]))))
  (testing "two increasing"
    (is (= 1 (max-profit [1 2]))))
  (testing "two decreasing"
    (is (= 0 (max-profit [2 1]))))
  (testing "best sale before later low"
    (is (= 2 (max-profit [2 4 1]))))
  (testing "multiple valleys"
    (is (= 4 (max-profit [3 2 6 5 0 3]))))
  (testing "all equal"
    (is (= 0 (max-profit [5 5 5]))))
  (testing "zero price"
    (is (= 10 (max-profit [0 4 0 10])))))
