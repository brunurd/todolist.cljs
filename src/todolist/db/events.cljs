(ns todolist.db.events
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-db
 :initialize
 (fn [_ _]
   {:todos []}))

(rf/reg-event-fx
 :add-todo
   (fn [{:keys [db]} [_ todo]]
     {:db (assoc db :todos (conj (:todos db) todo))}))

(defn update-handler [todos id k v]
  (map (fn [item]
         (if (= (:id item) id)
           (assoc item k v)
           item)) todos))

(defn remove-handler [todos id]
  (filter (fn [item]
            (not (= (:id item) id)))
          todos))

; TODO: Try to use assoc-in.
(rf/reg-event-fx
 :update-todo
 (fn [{:keys [db]} [_ id k v]]
   {:db (assoc db :todos (update-handler (:todos db) id k v))}))

; TODO: Try to use assoc-in.
(rf/reg-event-fx
 :remove-todo
 (fn [{:keys [db]} [_ id]]
   {:db (assoc db :todos (remove-handler (:todos db) id))}))