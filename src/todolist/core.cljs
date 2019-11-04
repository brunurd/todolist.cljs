(ns todolist.core
  (:require 
   [reagent.core :as r]
   [todolist.components.main :refer (main)]
   [todolist.db.core :as db]))

(defn start []
  (r/render-component [main]
                      (. js/document (getElementById "app"))))

(defn ^:export init []
  (db/init)
  (start))

(defn stop []
  (js/console.log "stop"))
