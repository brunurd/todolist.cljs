(ns todolist.state
  (:require
   [reagent.core :as r]))

(defonce data (r/atom []))

(defn get-state [] @data)

(defn add-todo! [todo]
  (swap! data conj todo))

(defn toggle-todo! [id active]
  (swap! data (fn [array]
                (map (fn [item]
                       (if (= (:id item) id)
                         (assoc item :active active)
                         item)) array))))

(defn remove-todo! [id]
  (swap! data (fn [array]
                (filter (fn [item]
                          (not (= (:id item) id)))
                        array))))