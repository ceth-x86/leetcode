(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [is-subsequence]]))

(deftest is-subsequence-test
  (testing "example 1: subsequence found"
    (is (= true (is-subsequence "abc" "ahbgdc"))))
  (testing "example 2: not a subsequence"
    (is (= false (is-subsequence "axc" "ahbgdc"))))
  (testing "empty s"
    (is (= true (is-subsequence "" "ahbgdc"))))
  (testing "both empty"
    (is (= true (is-subsequence "" ""))))
  (testing "s longer than t"
    (is (= false (is-subsequence "abc" "ab"))))
  (testing "s equals t"
    (is (= true (is-subsequence "abc" "abc"))))
  (testing "single char match"
    (is (= true (is-subsequence "a" "a"))))
  (testing "single char no match"
    (is (= false (is-subsequence "a" "b"))))
  (testing "match at end"
    (is (= true (is-subsequence "c" "abc"))))
  (testing "empty t non-empty s"
    (is (= false (is-subsequence "a" "")))))
