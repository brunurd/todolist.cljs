(ns todolist.db.subs
  (:require 
   [re-frame.core :as rf]))

(rf/reg-sub
 :todos
 (fn [db _]
   (:todos db)))