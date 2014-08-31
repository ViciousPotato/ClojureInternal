For this little recursion program:

```clojure
(defn pow [base exp]
  (if (zero? exp)
    1
    (* base (pow base (dec exp)))))
```
Proves Java stack is a bit too small in default case:
```
honglinz@ubuntu:/media/sf_Projects/clojureinternal/src/clojureinternal$ clojure recursion.clj 2>&1 | wc -l
1025
```

Note: in shell redirection `>&` should stay close with 1/2. i.e. should be:
`2>&1` not `2 >& 1`

```clojure
(defn pow2 [base exp]
  (letfn [(kapow [base exp acc]
    (if (zero? exp)
      acc
      (recur base (dec exp) (* base acc))))]
  (kapow base exp 1)))

(println (pow2 2N 10000))
```

Difference between Joy of Clojure 1ed and 2ed is this pow needs 2 to be `2N` explicitly, I think it's decimal with N. So the question is:
`Design question: should there be automatically implictly type conversion`

Use lazy-seq to avoid writing tail recursion, interesting, how?

Question: How clojure compiler translates recur program.

The convert program is pretty interesting.
The elevator trampoline program has a minor defection: trying to close a closed door should not be treated as invalid.

Basically trampoline means returning a continuing function for caller to call, freeing up stack.
