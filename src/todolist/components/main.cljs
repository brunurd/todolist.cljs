(ns todolist.components.main
  (:require 
   [todolist.components.add-todo :refer (add-todo)]
   [todolist.components.todos-list :refer (todos-list)]))

(defn main []
  [:main {:class "main"}
   [:h1 "Todo's List"]
   [add-todo]
   [todos-list]])