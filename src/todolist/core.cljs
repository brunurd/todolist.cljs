(ns todolist.core
  (:require 
   [reagent.core :as reagent]
   [todolist.components.main :refer (main)]))

(defn start []
  (reagent/render-component [main]
                            (. js/document (getElementById "app"))))

(defn ^:export init []
  (start))

(defn stop []
  (js/console.log "stop"))
