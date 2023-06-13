# Parking API Documentation

This document provides  documentation for the REST API, which allows users to list the nearby parking lots and see in RealTime the number of available spots.

## Base URL

The base URL for the API is: `https://localhost:8080/api/`

The API Docs for this API is : `http://localhost:8080/v3/api-docs`

The Swagger ui page for this API is : `http://localhost:8080/swagger-ui/index.html`

## Endpoints

### Retrieve List of Parking

Retrieves a list of parking lots with the number of available spots.

- **Endpoint:** `/parking`
- **Method:** GET
- **Parameters:**
    - None
- **Response:**
    - **Status Code:** 200 OK
    - **Content Type:** application/json
    - **Body:** An array of ParkingRecord objects with the following properties:
        - `id` (string): The unique identifier of the entity.
        - `nom` (string): The name of the parking lot.
        - `adresse` (string): The address of the parking lot.
        - `info` (string): Shows additional informations about the parking lot.
        - `nb_places` (int): The number of spots in parking lot.
        - `availableSpaces` (int): The number of available spots in parking lot.

In this work we have two URLs for retrieving Parking lot data, one for getting the list for the parking lots and doesn't provide any informations about the available spots, here where the second URL is used because it gives us the available spots in RealTime but we have some challenges :

- First : the realTime information about the available spots doesn't cover all the parking lots that exists in the List that we get from the other link. That's why we verified each parking information before sending the responce :
    - When the parking doesn't provide information about the available spots, we set their number to "-1"
    - We display the provide the capacity number on all parking, so that when the information about the available spots is missing, the user can try a parking that has a big capacity, this information can help him find an empty spot to park if it's a large parking lot.
- Second : The JSON files provided have nested lists of objects and they are not similar, that's why we created some classes to help us extract the data in a clean way and make it easy for us to do the business logic on this data.

- The URLs were put externally so that they can be updated easily via "application.properties" file.

The type of authentication used in this API is Basic Authentication provided by Spring Security by using those credentials :
- The username : "user"
- The password : provided on the run by Spring, you can view it on the console
