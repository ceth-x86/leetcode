(ns solution-test
  (:require [clojure.test :refer :all]
            [solution :refer :all]))

(deftest test-longest-common-prefix
  (is (= (longest-common-prefix ["flower" "flow" "flight"]) "fl"))
  (is (= (longest-common-prefix ["dog" "racecar" "car"]) ""))
  (is (= (longest-common-prefix ["ab" "a"]) "a"))
  (is (= (longest-common-prefix [""]) ""))
  (is (= (longest-common-prefix ["a"]) "a")))
