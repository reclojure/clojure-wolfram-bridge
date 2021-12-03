(ns notebook.demo
  (:require clojuratica.core
            [clojuratica.tools.clerk-helper :refer [view]]
            [nextjournal.clerk :as nb]
            [nextjournal.beholder :as beholder]
            [nextjournal.clerk.webserver :as webserver]
            [clojure.java.browse :refer [browse-url]]))

;; # Geo

(view '(GeoGraphics
        [Red (GeoPath [(Entity "City" ["Portland" "Oregon" "UnitedStates"])
                       (Entity "City" ["Orlando" "Florida" "UnitedStates"])
                       (Entity "City" ["Boston" "Massachusetts" "UnitedStates"])]
                      "Geodesic")]))


;; # Time

(view '(TimelinePlot
        [(Entity "HistoricalEvent" "WorldWar1")
         (Entity "HistoricalEvent" "WorldWar2")
         (Entity "HistoricalEvent" "VietnamWar")
         (Entity "HistoricalEvent" "KoreanWarBegins")]))

(view '(GeoGraphics))

(view '(GeoImage (Entity "City" ["NewYork" "NewYork" "UnitedStates"])))


;; # Numbers

(view '(BarChart (EntityValue (EntityClass "Planet" All) "Radius")))

;; # 3D

(view '(MoleculePlot3D (Molecule "O=C(C1CCC1)S[C@@H]1CCC1(C)C")))

;; # Animate!

(view '(Animate (Plot (Sin (+ x a)) [x 0 10]) [a 0 5] (-> AnimationRunning true)))

(comment ;; Start A Clerk Notebook

  ;; evaluate the ns

  ;; start server & watcher

    (do
      (webserver/start! {:port 7777})

      (future
        (let [watch-paths ["notebook/"]]
          (reset! nb/!watcher {:paths watch-paths
                               :watcher (apply beholder/watch-blocking #(nb/file-event %) watch-paths)})))
      (prn "Clerk Started!")
      (browse-url "http://localhost:7777"))

    ;; change something and save!

  )
