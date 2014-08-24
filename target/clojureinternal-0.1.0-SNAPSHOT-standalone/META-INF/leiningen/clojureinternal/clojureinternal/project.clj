(defproject clojureinternal "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/ViciousPotato/ClojureInternal"
  :license {:name "The MIT License (MIT)"
            :url "http://www.opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main clojureinternal.hello
  :profiles {
    :uberjar {:aot :all}
  })
