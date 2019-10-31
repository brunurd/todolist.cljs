(ns todolist.state
  (:require
   [reagent.core :as r]))

(defonce data (r/atom []))

(defn get-state [] @data)

(defn add [todo]
  (swap! data conj todo))

(defn swap-active [id active]
  (swap! data (fn [array]
                (map (fn [item]
                       (if (= (:id item) id)
                         (assoc item :active active)
                         item)) array))))

(defn rm [id]
  (swap! data (fn [array]
                (filter (fn [item]
                          (not (= (:id item) id)))
                        array))))