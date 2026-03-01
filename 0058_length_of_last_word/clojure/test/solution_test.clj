(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [length-of-last-word]]))

(deftest length-of-last-word-test
  (testing "example 1"
    (is (= 5 (length-of-last-word "Hello World"))))
  (testing "example 2: trailing spaces"
    (is (= 4 (length-of-last-word "   fly me   to   the moon  "))))
  (testing "example 3"
    (is (= 6 (length-of-last-word "luffy is still joyboy"))))
  (testing "single word"
    (is (= 5 (length-of-last-word "Hello"))))
  (testing "single word with spaces"
    (is (= 5 (length-of-last-word "   Hello   "))))
  (testing "single char"
    (is (= 1 (length-of-last-word "a"))))
  (testing "all same chars"
    (is (= 4 (length-of-last-word "aaaa"))))
  (testing "many spaces between"
    (is (= 1 (length-of-last-word "a   b"))))
  (testing "sentence"
    (is (= 3 (length-of-last-word "Today is a nice day")))))
