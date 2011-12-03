(ns student.dialect
  (:require [clojure.string :as str]))

(defn canadianize [sentence] (str/replace sentence #"\.$" ", eh?"))


(defn pig-latinize-word [word]
  (def matcher (re-matcher #"(^\w)(\w+)" word))
  (def first-last (rest (re-find matcher)))
  (str (last first-last) (first first-last) "ay"))

(defn pig-latinize [sentence]
  (str/replace sentence #"\w+" #(pig-latinize-word %1)))
