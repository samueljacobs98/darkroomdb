# Darkroomdb

## Project Overview

Created an API using Spring Boot and Java with a MySQL database. The functionality of the API was verified in localhost with Postman. The API and it's database was then launched into the cloud using Google Cloud Platform.

This API was created to work as the backend of a larger, full-stack project. The front-end site and repo can be found in the links below:

https://github.com/samueljacobs98/darkroomdb-fe

https://samueljacobs98.github.io/darkroomdb-fe/

# Documentation

## Root End Point

Access the API using this end point.

```
https://darkroomdb.nw.r.appspot.com/
```

## GET Requests

<!-- 1. -->

### Return **all** Filmstocks in the database.

```
https://darkroomdb.nw.r.appspot.com/film
```

<!-- 2. -->

### Return a film by it's ID in the databse.

```
https://darkroomdb.nw.r.appspot.com/film/{id}
```

_Example_:

```
https://darkroomdb.nw.r.appspot.com/film/2
```

## POST Requests

<!-- 1. -->

### Add a filmstock to the database.

A Filmstock must be an object contained in the body of the request. This object should look like the one seen below:

```
{
    "name": "CineStill 800T",
    "ratings": [
        {
            "rating": 3.5
        }
    ],
    "info": "CineStill 800T is a 35mm tungsten-balanced colour negative film made from Kodak motion picture film stock.",
    "iso": 800,
    "formats": [
        {
            "format": "35mm"
        },
        {
            "format": "120"
        }
    ],
    "style": "colour"
}
```

Note that the any initial rating you wish to provide must be provided within the ratings array of objects, where the object contains a key-value pair of "rating" and a number between 0 and 5.

```
https://darkroomdb.nw.r.appspot.com/film
```

<!-- 2. -->

### Add a new rating to a specific filmstock

Make a post request and provide the id of the film you would like to add a rating for as a path variable. In the body, provide a number, between 0 and 5, as a rating.

```
https://darkroomdb.nw.r.appspot.com/film/{id}
```

_Example_:

```
https://darkroomdb.nw.r.appspot.com/film/2
```

## DELETE Requests

<!-- 1. -->

Delete a filmstock from the database by id.

```
https://darkroomdb.nw.r.appspot.com/film/{id}
```

_Example_:

```
https://darkroomdb.nw.r.appspot.com/film/2
```
