(ns todolist.components.todos-list
  (:require
   [todolist.components.todo-item :refer (todo-item)]
   [todolist.state :refer (todos)]))

(defn todos-list []
  [:ul {:class "todos-list"}
   (for [todo (todos)]
     ^{:key todo} [todo-item todo])])