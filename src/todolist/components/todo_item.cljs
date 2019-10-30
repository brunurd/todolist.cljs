(ns todolist.components.todo-item)

(def active-style {:text-decoration "none" :color "black"})
(def done-style {:text-decoration "line-through" :color "gray"})

(defn todo-item [item-data]
  [:li {:class "item"}
   [:input {:type "checkbox"}]
   [:p {:style (if (:active item-data) active-style done-style)} (:text item-data)]
   [:button {:type "button"} "x"]])
