# Atipera GitHub REST API application

## Introduction

Is a Java application powered by Spring Boot that allows to retrieve a list of owned GitHub repositories by given user.

This application provides an easy way to view all public repositories of given GitHub user, excluding any forks.

## API Reference

#### Get repositories of given user (forks excluded)

```http
  GET /api/v1/github/users/${username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Required**. GitHub username |

## Tech Stack

Java 17, Spring Boot, GitHub API integration
## Dependencies

- ModelMapper -> https://modelmapper.org/
- Spring Boot -> https://spring.io/projects/spring-boot
- Lombok -> https://projectlombok.org/
## Authors

- [@JasinskiSz](https://www.github.com/JasinskiSz)