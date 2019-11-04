(ns todolist.components.todos-list
  (:require
   [re-frame.core :as rf]
   [todolist.components.todo-item :refer (todo-item)]))

(defn todos-list []
  [:ul {:class "todos-list"}
   (map (fn [todo]
          ^{:key todo} [todo-item todo])
        @(rf/subscribe [:todos]))])