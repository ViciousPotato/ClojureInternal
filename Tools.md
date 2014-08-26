##How to Investigate

Purpose: Compile clojure code and investigate JVM bytecode.

###Clojure compilation:

Reference: http://www.beaconhill.com/blog/?p=283

1. Add gen-class
```clojure
(ns cmdline.core
  (:require [clojure.java.io :as io])
  (:gen-class :main true))
```

2. Define main
```clojure
(defn -main
  "The application's main function"
  [& args]
  (println args))
```

3. Build
lein uberjar

OR

(compile 'ns.module)

###Class decompilation:

- javap -c
- jad



From initial decompiling it seems clojure simply creates a wrapper and load .clj files at RT.

Question: what does AOT do then,
