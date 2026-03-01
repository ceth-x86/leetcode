(ns solution-followup-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution-followup :refer [build-index-map is-subsequence-followup]]))

(def ahbgdc-map (build-index-map "ahbgdc"))

(deftest followup-test
  (testing "example 1: subsequence found"
    (is (= true (is-subsequence-followup ahbgdc-map "abc"))))
  (testing "example 2: not a subsequence"
    (is (= false (is-subsequence-followup ahbgdc-map "axc"))))
  (testing "empty s"
    (is (= true (is-subsequence-followup ahbgdc-map ""))))
  (testing "s equals t"
    (is (= true (is-subsequence-followup ahbgdc-map "ahbgdc"))))
  (testing "single char match"
    (is (= true (is-subsequence-followup ahbgdc-map "a"))))
  (testing "match at end"
    (is (= true (is-subsequence-followup ahbgdc-map "c"))))
  (testing "repeated char not enough"
    (is (= false (is-subsequence-followup ahbgdc-map "aaa"))))
  (testing "non-contiguous match"
    (is (= true (is-subsequence-followup ahbgdc-map "abdc"))))
  (testing "s longer than t"
    (is (= false (is-subsequence-followup ahbgdc-map "ahbgdca")))))

(deftest followup-empty-t-test
  (let [m (build-index-map "")]
    (testing "empty s on empty t"
      (is (= true (is-subsequence-followup m ""))))
    (testing "non-empty s on empty t"
      (is (= false (is-subsequence-followup m "a"))))))

(deftest followup-repeated-chars-test
  (let [m (build-index-map "aabbc")]
    (testing "abc"
      (is (= true (is-subsequence-followup m "abc"))))
    (testing "aab"
      (is (= true (is-subsequence-followup m "aab"))))
    (testing "aabbc"
      (is (= true (is-subsequence-followup m "aabbc"))))
    (testing "aabbcc"
      (is (= false (is-subsequence-followup m "aabbcc"))))))

(deftest followup-many-queries-test
  (let [m (build-index-map "abcdefghijklmnopqrstuvwxyz")]
    (testing "ace"
      (is (= true (is-subsequence-followup m "ace"))))
    (testing "az"
      (is (= true (is-subsequence-followup m "az"))))
    (testing "za"
      (is (= false (is-subsequence-followup m "za"))))
    (testing "xyz"
      (is (= true (is-subsequence-followup m "xyz"))))))
