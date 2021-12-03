(ns wl-symbols-loader
  (:require [clojuratica.core :as wl]
            [clojure.java.io :as io]))

(defn load-all-symbols [ns-sym]
  (wl/eval (let [path-string (.toString (.getParent (io/file (io/resource "wld.wl"))))]
             `(AppendTo $Path ~path-string)))
  (doall (->> '(Get "wld.wl")
              wl/eval
              (map vec)
              (map (fn [[sym doc]]
                     (wl/clj-intern (symbol sym) {:intern/ns-sym ns-sym
                                                  :intern/extra-meta {:doc doc}}))))))
