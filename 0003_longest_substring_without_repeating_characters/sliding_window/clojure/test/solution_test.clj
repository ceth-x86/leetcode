(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [length-of-longest-substring]]))

(deftest length-of-longest-substring-test
  (testing "examples"
    (is (= 3 (length-of-longest-substring "abcabcbb")))
    (is (= 1 (length-of-longest-substring "bbbbb")))
    (is (= 3 (length-of-longest-substring "pwwkew"))))
  (testing "edge cases"
    (is (= 0 (length-of-longest-substring "")))
    (is (= 1 (length-of-longest-substring "a")))
    (is (= 6 (length-of-longest-substring "abcdef")))
    (is (= 2 (length-of-longest-substring "abba")))
    (is (= 3 (length-of-longest-substring "dvdf")))
    (is (= 2 (length-of-longest-substring "aab")))
    (is (= 5 (length-of-longest-substring "tmmzuxt")))
    (is (= 5 (length-of-longest-substring "a! b@a")))))
