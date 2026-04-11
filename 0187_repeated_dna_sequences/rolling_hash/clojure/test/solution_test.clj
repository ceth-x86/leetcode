(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [solution :refer [find-repeated-dna-sequences]]))

(deftest repeated-dna-sequences-test
  (testing "example one"
    (is (= #{"AAAAACCCCC" "CCCCCAAAAA"}
           (set (find-repeated-dna-sequences "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")))))
  (testing "example two"
    (is (= ["AAAAAAAAAA"]
           (find-repeated-dna-sequences "AAAAAAAAAAAAA"))))
  (testing "too short"
    (is (= []
           (find-repeated-dna-sequences "ACGT"))))
  (testing "exactly ten"
    (is (= []
           (find-repeated-dna-sequences "ACGTACGTAC"))))
  (testing "same fragment returned once"
    (is (= ["AAAAAAAAAA"]
           (find-repeated-dna-sequences "AAAAAAAAAAAA")))))
