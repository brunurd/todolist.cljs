(ns todolist.components.todos-list
  (:require
   [re-frame.core :as rf]
   [todolist.components.todo-item :refer (todo-item)]))

(defn todos-list []
  [:ul {:class "todos-list"}
   (for [todo @(rf/subscribe [:todos])]
     ^{:key todo} [todo-item todo])])