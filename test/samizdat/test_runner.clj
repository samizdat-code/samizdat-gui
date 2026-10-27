;; samizdat-gui - the standalone GTK client for samizdat
;; Copyright (C) 2026 Dmitri Sotnikov
;; SPDX-License-Identifier: GPL-3.0-or-later

(ns samizdat.test-runner
  (:require [clojure.test :as t]
            [samizdat.gui-api-test]
            [samizdat.gui-approval-test]
            [samizdat.gui-ops-test]
            [samizdat.gui-graph-test]
            [samizdat.gui-style-test]
            [samizdat.gui-input-test]
            [samizdat.gui-mathtext-test]
            [samizdat.gui-newrun-test]))

(def namespaces
  '[samizdat.gui-api-test
    samizdat.gui-approval-test
    samizdat.gui-ops-test
    samizdat.gui-graph-test
    samizdat.gui-style-test
    samizdat.gui-input-test
    samizdat.gui-mathtext-test
    samizdat.gui-newrun-test])

(defn run []
  (apply t/run-tests namespaces))

(defn -main [& _]
  (let [{:keys [fail error] :as summary} (run)]
    (println)
    (println summary)
    (System/exit (if (pos? (+ (or fail 0) (or error 0))) 1 0))))
