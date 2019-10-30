(ns todolist.state
  (:require 
   [reagent.core :as r]))

(defonce data (r/atom []))

(defn add-task [task]
  (swap! data conj task))

(defn get-state [] @data)