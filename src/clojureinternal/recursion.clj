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

(println (pow2 2N 10000))