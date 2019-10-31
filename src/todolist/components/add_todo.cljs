(ns todolist.components.add-todo
  (:require
   [reagent.core :as r]
   [todolist.state :refer (add-todo!)]))

(def new-todo (r/atom ""))

(defn add-todo []
  (let [on-change-handler (fn [e]
                            (let [value (-> e .-target .-value)]
                              (reset! new-todo value)))
        on-submit-handler (fn [e]
                            (.preventDefault e)
                            (when (not (= @new-todo ""))
                              (add-todo! {:id (js/Date.now)
                                    :active true
                                    :name @new-todo})
                              (reset! new-todo "")))]
    [:form {:class "add-todo"
            :onSubmit on-submit-handler}
     [:input {:type "text"
              :placeholder "Type a todo text here..."
              :value @new-todo
              :on-change on-change-handler}]
     [:button {:type "submit"} "Add"]]))