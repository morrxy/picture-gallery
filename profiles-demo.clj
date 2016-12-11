;; WARNING
;; The profiles.clj file is used for local environment variables, such as database credentials.
;; This file is listed in .gitignore and will be excluded from version control by Git.

{:profiles/dev  {:env {:database-url "jdbc:postgresql://localhost/picture_gallery_dev?user=gallery&password=pictures"}}
 :profiles/test {:env {:database-url "jdbc:postgresql://localhost/picture_gallery_test?user=gallery&password=pictures"}}}
