(ns todolist.components.main
  (:require [reagent.core :as r :refer [atom]]
            [todolist.components.form :refer (form)]
            [todolist.components.items-list :refer (items-list)]))

(defonce data (atom [{:id 0 :text "Test1" :active true}
                     {:id 1 :text "Test2" :active true}]))

(defn main [] [:main {:class "main"}
               [:h1 "Todo's List"]
               [form]
               [items-list data]])