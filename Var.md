Dynamically Scoped

```clojure
(defn print-read-eval []
  (println "*read-eval* is currently" *read-eval*))

(defn binding-play []
  (print-read-eval)
  (binding [*read-eval* false]
    (print-read-eval))
  (print-read-eval))
  
(binding-play)
; *read-eval* is currently true
; *read-eval* is currently false
; *read-eval* is currently true
  ```
