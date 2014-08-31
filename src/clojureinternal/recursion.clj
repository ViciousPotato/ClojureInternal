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

(defn elevator [commands]
  (letfn
    [(ff-open [[_ & r]]
      #(case _
        :close (ff-closed r)
        :done  true
        false))
    (ff-closed [[_ & r]]
      #(case _
        :open (ff-open r)
        :up   (sf-closed r)
        false))
    (sf-closed [[_ & r]]
      #(case _
        :down (ff-closed r)
        :open (sf-open r)
        false))
    (sf-open [[_ & r]]
      #(case _
        :close (sf-closed r)
        :done  true
        false))]
    (trampoline ff-open commands)))

(elevator (cycle [:close :open]))