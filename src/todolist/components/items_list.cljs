(ns todolist.components.items-list
  (:require [todolist.components.item :refer (item)]))

(defn items-list [tasks]
  [:ul {:class "items-list"}
   (for [task @tasks]
     ^{:key task} [item tasks task])])