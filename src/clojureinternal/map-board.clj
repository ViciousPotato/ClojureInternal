(def initial-board
  [[:- :k :-]
   [:- :- :-]
   [:- :K :-]])

(defn board-map [f bd]
  (vec (map #(vec (map f %)) bd)))

(board-map #(println %) initial-board)