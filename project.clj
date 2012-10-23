(defproject gregory "1.0.0-SNAPSHOT"
  :description "Gregory's Theorem in Clojure"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/math.numeric-tower "0.0.1"]]
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :compile-path "target/classes"
  :target-path "target/"
  :repl-options {:init-ns gregory.polynomial})
