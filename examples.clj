(ns examples
  (:require
   [clojuratica.core :as wl]
   [clojure.repl :as repl]
   [clojuratica.lib.helpers :as h]
   [wl-symbols-loader :refer [load-all-symbols]]))

;; Eval as data (note the the single quote)

(wl/eval '(Map (Function [x] (+ x 1)) [1 2 3]))

;; Load All WL Symbols

(load-all-symbols (.name *ns*))

;; Test
(Dot [1 2 3] [4 5 6])

;; Editor Integration

(repl/doc GeoBackground)

(repl/find-doc "molecule")

(repl/apropos #"(?i)geo")

(h/help! 'Axes)

(h/help! '(Take
            (Sort
             (Map
              (Function [gene]
                        [(GenomeData gene "SequenceLength") gene])
              (GenomeData)))
            n)
          :return-links true)

(Information 'GenomeData)

(wl/wl '((WolframLanguageData "GenomeData") "Association"))
,
