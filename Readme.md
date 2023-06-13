# Parking API Documentation

This document provides  documentation for the REST API, which allows users to list the nearby parking lots and see in realTime the number of available spots.

## Base URL

The base URL for the API is: `https://localhost:8080/api/`

## Endpoints

### Retrieve List of Entities

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


