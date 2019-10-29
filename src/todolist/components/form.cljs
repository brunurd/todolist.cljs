(ns todolist.components.form)

(defn form [] [:form {:class "form"
                      :onSubmit (fn [e]
                                  (.preventDefault e))}
               [:input {:name "new-task" :type "text" :placeholder "Type a task here..."}]
               [:button {:type "submit" :style {:margin-left 12}} "Add"]])