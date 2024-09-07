(ns demo.linked-map
  (:require [clojure.test :refer :all]
            [linked.core :as linked]
            [schema.core :as s :refer [defschema]]))

(defschema Phone (linked/map
                   :phone_number  s/Str
                   :country_code  s/Str))

(defschema Request
  (-> (linked/map
        :id              s/Str
        :email           s/Str
        :phone           s/Str)
      #_(s/constrained (some-fn #(contains? % :emailAddress)
                                #(and (contains? % :phone) (not (nil? (get-in % [:phone :phoneNumber])))))
                       'email-or-phone-required)))