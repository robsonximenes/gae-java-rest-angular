# appengine + java + rest + angular sample

This projetc helps to create a simple app ready to run on Google Appengine. 

Just clone de projetc and use maven to run the app.


## Features

  - REST with Jersey
    - Register
    - Login
    - User
  - Security Filter (Basic Authentication per request)
  - Angular APP ( no CSS, just a simple app)
    - Consume REST services
    - Implements security
    - Dependences managed by bower (just run "bower install" at webapp dir)
  - Persistence at google data store with Objectfy 

## Running

```sh
mvn appengine:devserver
```

## DEPLOY

The file WEB-INF/appengine.xml uses de app.version parameter from pom.xml to deploy at google.

```sh
mvn appengine:update
```
