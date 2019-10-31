(ns todolist.state
  (:require
   [reagent.core :as r]))

(defonce todos-data (r/atom []))

(defn todos [] @todos-data)

(defn add-todo! [todo]
  (swap! todos-data conj todo))

(defn update-todo! [id k v]
  (swap! todos-data (fn [todo-items]
                (map (fn [item]
                       (if (= (:id item) id)
                         (assoc item k v)
                         item)) todo-items))))

(defn remove-todo! [id]
  (swap! todos-data (fn [todo-items]
                (filter (fn [item]
                          (not (= (:id item) id)))
                        todo-items))))