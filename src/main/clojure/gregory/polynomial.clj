(ns gregory.polynomial
  (:require [clojure.math.numeric-tower :as math]))

;;;can the polynomial data structure be a function
;;;so you can call (p 42) and it will evaluate?


;;;stolen from stackoverflow #644246
;;;(use 'clojure.contrib.seq-utils 'clojure.contrib.math)
;;;(defn polynomial [& cs]
;;;  #(apply +
;;;          (map (fn [[pow c]] (* c (expt % pow)))
;;;               (indexed cs))))
;;;
;;;((polynomial 1601 -79 1) 42)   ; => 47



(defn remove-trailing-zeroes [vec]
  (if (= (peek vec) 0)
    (remove-trailing-zeroes (pop vec))
    vec))

(defn evaluate [p x]
  (reduce + (map-indexed (fn [i v]
                           (* (math/expt x i) v))
                         p)))

(defn plus [p q]
  (let [[smaller bigger] (sort [p q])]
    (map-indexed #(+ %2 (or (get smaller %1) 0))
                 bigger)))

(defn times [p q]
  (let [r []]
    (map-indexed (fn [i pval]
           (map-indexed (fn [j qval]
                          (replace
                           {(+ i j)
                            (+ (or (get r (+ i j)) 0) (* pval qval))}
                           r))
                q))
         p)))
