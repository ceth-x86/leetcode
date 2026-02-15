(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [anagram?]]))

(deftest anagram-test
  (testing "anagram match"
    (is (true? (anagram? "anagram" "nagaram"))))
  (testing "no match"
    (is (false? (anagram? "rat" "car"))))
  (testing "single char equal"
    (is (true? (anagram? "a" "a"))))
  (testing "single char differ"
    (is (false? (anagram? "a" "b"))))
  (testing "different lengths"
    (is (false? (anagram? "ab" "abc"))))
  (testing "same string"
    (is (true? (anagram? "abc" "abc"))))
  (testing "all same char"
    (is (true? (anagram? "aaa" "aaa"))))
  (testing "count mismatch"
    (is (false? (anagram? "aacc" "ccac")))))
