(def project 'testdeploy)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [adzerk/bootlaces "0.1.13"]
                            [adzerk/boot-test "RELEASE" :scope "test"]])

(task-options!
 pom {:project     'org.clojars.d0x-mike/testdeploy
      :version     version
      :description "FIXME: write description"
      :url         "http://example/FIXME"
      :scm         {:url "https://github.com/yourname/testdeploy"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]]
         '[adzerk.bootlaces :refer :all])

(bootlaces! version)
