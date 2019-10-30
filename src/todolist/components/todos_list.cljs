(ns todolist.components.todos-list
  (:require 
   [todolist.components.todo-item :refer (todo-item)]
   [todolist.state :refer (get-state)]))

(defn todos-list []
  [:ul {:class "items-list"}
   (for [task (get-state)]
     ^{:key task} [todo-item task])])