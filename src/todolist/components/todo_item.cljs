(ns todolist.components.todo-item
  (:require
   [todolist.state :refer (toggle-todo! remove-todo!)]))

(def active-style {:text-decoration "none" :color "black"})
(def done-style {:text-decoration "line-through" :color "gray"})

(defn todo-item [item-data]
  (let [on-check-handler (fn [e]
                           (let [checked (-> e .-target .-checked)]
                             (toggle-todo! (:id item-data) (not checked))))
        on-remove-handler (fn []
                            (remove-todo! (:id item-data)))]
    [:li {:class "todo-item" :id (:id item-data)}
     [:input {:type "checkbox"
              :checked (not (:active item-data))
              :on-change on-check-handler}]
     [:p {:style (if (:active item-data) active-style done-style)} (:name item-data)]
     [:button {:type "button"
               :on-click on-remove-handler} "x"]]))
