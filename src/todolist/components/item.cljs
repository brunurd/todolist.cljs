(ns todolist.components.item)

(def active-style {:text-decoration "none" :color "black"})
(def done-style {:text-decoration "line-through" :color "gray"})

(defn item [data item-data]
  [:li {:class "item"}
   [:input {:type "checkbox"
            :on-click (fn [e]
                        (let [checked (.-checked (.-target e))]
                          (swap! data update-in [(:id item-data)] assoc :active (not checked))))}]
   [:p {:style (if (:active item-data) active-style done-style)} (:text item-data)]
   [:button {:type "button"} "x"]])
