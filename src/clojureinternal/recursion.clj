(defn pow [base exp]
  (if (zero? exp)
    1
    (* base (pow base (dec exp)))))

(defn pow2 [base exp]
  (letfn [(kapow [base exp acc]
    (if (zero? exp)
      acc
      (recur base (dec exp) (* base acc))))]
  (kapow base exp 1)))

(def simple-metric {:meter 1,
                    :km 1000,
                    :cm 1/100,
                    :mm [1/10 :cm]})

(defn convert [context descriptor]
  (reduce (fn [result [mag unit]]
    (+ result
      (let [val (get context unit)]
        (if (vector? val)
          (* mag (convert context val))
          (* mag val)))))
    0
    (partition 2 descriptor)))

;; (println (pow2 2N 10000))
(println (convert simple-metric [1 :meter]))
(println (convert simple-metric [1 :cm]))