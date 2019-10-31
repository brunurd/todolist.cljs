(ns todolist.components.add-todo
  (:require
   [reagent.core :as r]
   [todolist.state :refer (add-todo!)]))

(def new-task (r/atom ""))

(defn add-todo []
  (let [on-change-handler (fn [e]
                            (let [value (-> e .-target .-value)]
                              (reset! new-task value)))
        on-submit-handler (fn [e]
                            (.preventDefault e)
                            (when (not (= @new-task ""))
                              (add-todo! {:id (js/Date.now)
                                    :active true
                                    :name @new-task})
                              (reset! new-task "")))]
    [:form {:class "form"
            :onSubmit on-submit-handler}
     [:input {:name "new-task"
              :type "text"
              :placeholder "Type a task here..."
              :value @new-task
              :on-change on-change-handler}]
     [:button {:type "submit" :style {:margin-left 12}} "Add"]]))