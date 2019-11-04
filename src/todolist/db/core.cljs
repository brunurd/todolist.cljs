(ns todolist.db.core
  (:require
   [re-frame.core :as rf]
   [todolist.db.subs]
   [todolist.db.events]))

(defn init []
  (rf/dispatch-sync [:initialize]))