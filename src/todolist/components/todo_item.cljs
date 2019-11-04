(ns todolist.components.todo-item
  (:require
   [re-frame.core :as rf]))

(def active-style {:text-decoration "none" :color "black"})
(def done-style {:text-decoration "line-through" :color "gray"})

(defn todo-item [item-data]
  (let [on-check-handler (fn [e]
                           (let [checked (-> e .-target .-checked)]
                             (rf/dispatch [:update-todo (:id item-data) :active (not checked)])))
        on-remove-handler (fn []
                            (rf/dispatch [:remove-todo (:id item-data)]))
        update-item-name (fn [e]
                           (let [value (-> e .-target .-innerHTML)]
                             (rf/dispatch [:update-todo (:id item-data) :name value])))]
    [:li {:class "todo-item" :id (:id item-data)}
     [:input {:type "checkbox"
              :checked (not (:active item-data))
              :on-change on-check-handler}]

     [:p
      {:content-editable (:active item-data)
       :suppress-content-editable-warning true
       :style (if (:active item-data) active-style done-style)
       :on-blur update-item-name}
      (:name item-data)]

     [:button {:type "button"
               :on-click on-remove-handler} "x"]]))
