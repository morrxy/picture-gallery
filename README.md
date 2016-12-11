# picture-gallery

generated using Luminus version "2.9.11.14"

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## DataBase

1. install PG

    `brew install postgresql`

2. start PG

    `pg_ctl -D /usr/local/var/postgres start`

3. create Application DB

    1. `psql postgres`
    2. `CREATE USER gallery WITH PASSWORD 'pictures';`
    3. `CREATE DATABASE picture_gallery_dev OWNER gallery;`
    4. `CREATE DATABASE picture_gallery_test OWNER gallery;`
    
## Profile

    cp profiles-demo.clj profiles.clj

## Migrate

    lein run migrate

## Running

To start a web server for the application, run:

    lein run
    
in another terminal, run:

    lein figwhell
    
in browser, open: 

    1. http://localhost:3000 
    2. http://localhost:3000/swagger-ui 
    3. http://localhost:3000/swagger-ui-private
    
## Test

    lein test
    
## Standalone Deployment

### package

    lein uberjar
    
### running

    export DATABASE_URL="jdbc:postgresql://localhost/picture_gallery_dev?user=gallery&password=pictures"
    
    java -jar target/uberjar/picture-gallery.jar

## License

Copyright © 2016 FIXME
