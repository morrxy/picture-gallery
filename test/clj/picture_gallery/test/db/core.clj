(ns picture-gallery.test.db.core
  (:require [picture-gallery.db.core :refer [*db*] :as db]
            [luminus-migrations.core :as migrations]
            [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [picture-gallery.config :refer [env]]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
      #'picture-gallery.config/env
      #'picture-gallery.db.core/*db*)
    (migrations/migrate ["migrate"] (select-keys env [:database-url]))
    (f)))

(deftest test-users
  (jdbc/with-db-transaction [t-conn *db*]
    (jdbc/db-set-rollback-only! t-conn)
    (is (= 1 (db/create-user!
               t-conn
               {:id         "1"
                :pass       "12345678"
                :pass-confirm "12345678"})))
    (is (= {:id         "1"
            :first_name nil
            :last_name  nil
            :email      nil
            :pass       "12345678"
            :admin      nil
            :last_login nil
            :is_active  nil}
           (db/get-user t-conn {:id "1"})))))
