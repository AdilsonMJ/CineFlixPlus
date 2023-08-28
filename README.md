# Movie Catalog and API Consumption Application (Rick and Rick e Morty)

This repository contains a Java Spring Boot project that provides functionalities related to movie catalog management and the consumption of a public API. The application is secured using Spring Security to ensure proper authentication and authorization.

## Features

1. **Movie Catalog Management:** The application allows users to manage a collection of movies. It provides endpoints for retrieving movies by different sorting criteria, filtering by attributes, and fetching movie details by ID.

2. **Public API Consumption:** The application also consumes a public API related to the "Rick and Morty" TV show. It offers endpoints to retrieve character and location information from the show.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)

## Security

The application employs Spring Security for authentication and authorization. JWT is used for token-based authentication. The project includes the necessary security configurations, filters, and services to ensure a secure environment.


## Endpoints

### Movie Management

#### Get All Movies Sorted by Alphabet
- Endpoint: `/movies`
- Method: GET
- Description: Retrieve a list of all movies sorted alphabetically.

#### Get All Movies Sorted by Year
- Endpoint: `/movies/moviesbyyear`
- Method: GET
- Description: Retrieve a list of all movies sorted by release year.

#### Get All Movies Sorted by Shuffle
- Endpoint: `/movies/moviesbyshuffle`
- Method: GET
- Description: Retrieve a list of all movies in a shuffled order.

#### Get All Movies Sorted by Gender
- Endpoint: `/movies/moviesbygender`
- Method: GET
- Description: Retrieve a list of all movies sorted by gender.

#### Get All Movies Sorted by Director
- Endpoint: `/movies/moviesbydirector`
- Method: GET
- Description: Retrieve a list of all movies sorted by director.

#### Get Movie by ID
- Endpoint: `/movies/id/{id}`
- Method: GET
- Description: Retrieve details of a movie by its ID.

#### Get Movies by Gender
- Endpoint: `/movies/gender/{gender}`
- Method: GET
- Description: Retrieve movies filtered by gender.

#### Get Movies by Year
- Endpoint: `/movies/year/{year}`
- Method: GET
- Description: Retrieve movies filtered by release year.

#### Get Movies by Director
- Endpoint: `/movies/director/{director}`
- Method: GET
- Description: Retrieve movies filtered by director.

#### Get Movie by Title
- Endpoint: `/movies/title/{title}`
- Method: GET
- Description: Retrieve details of a movie by its title.

### Rick and Morty API Consumption

#### Get Character by ID
- Endpoint: `/rickAndMorty/character/{id}`
- Method: GET
- Description: Retrieve character details from the "Rick and Morty" show by ID.

#### Get Location by ID
- Endpoint: `/rickAndMorty/location/{id}`
- Method: GET
- Description: Retrieve location details from the "Rick and Morty" show by ID.

#### Get All Characters
- Endpoint: `/rickAndMorty/characters`
- Method: GET
- Description: Retrieve a list of all characters from the "Rick and Morty" show.

### Authentication and Authorization

#### User Login
- Endpoint: `/auth/login`
- Method: POST
- Description: Authenticate a user and generate a JSON Web Token (JWT) for authorization.

#### User Registration
- Endpoint: `/auth/register`
- Method: POST
- Description: Register a new user.

## Setup and Usage

1. Clone the repository.
2. Configure application properties, including database settings and API credentials.
3. Build and run the application using a Java IDE or the command line.


Feel free to contribute to the project by submitting pull requests or suggesting improvements.

---

*Note: This README provides an overview of the project. For detailed documentation and setup instructions, please refer to the project's source code and relevant comments.*
