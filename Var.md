Dynamically Scoped
=======
Var is very interesting, it's dynamically bound, e.g. even lexically there is an upper level same var, during rt, it will try look up its value in the runtime upper level.

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

Question: if defn is also Var, does it mean function names are dunamically bound?