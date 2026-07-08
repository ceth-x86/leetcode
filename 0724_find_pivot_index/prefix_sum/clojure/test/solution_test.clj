(ns solution-test
  (:require [clojure.test :refer :all]
            [solution :refer [pivot-index]]))

(deftest pivot-index-test
  (is (= 3 (pivot-index [1 7 3 6 5 6])))
  (is (= -1 (pivot-index [1 2 3])))
  (is (= 0 (pivot-index [2 1 -1])))
  (is (= 0 (pivot-index [0]))))
