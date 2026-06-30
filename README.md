# Kusumika SMS

School Management System backend for Kusumika.

## Overview

This is a Spring Boot application that exposes student management APIs using MyBatis.
It supports two runtime profiles:

- `h2` - in-memory H2 database for local development and testing
- `dev` - PostgreSQL datasource for integration or production-like usage

## Requirements

- Java 17
- Gradle wrapper (`gradlew` / `gradlew.bat`)
- PostgreSQL (only required for `dev` profile)

## Run

### Run with H2

```powershell
.\gradlew bootRun --args='--spring.profiles.active=h2'
```

### Run with PostgreSQL

```powershell
.\gradlew bootRun --args='--spring.profiles.active=dev'
```

The application loads profile-specific configuration from:

- `src/main/resources/properties/application-h2.properties`
- `src/main/resources/properties/application-dev.properties`

## Application URL

The app is configured with a context path of `/kusumika-sms`, so the base URL is:

```text
http://localhost:8080/kusumika-sms
```

## API Endpoints

- `GET /kusumika-sms/student` - retrieve all students
- `GET /kusumika-sms/student/{id}` - retrieve a student by ID

## H2 Console

When running with `h2` profile, the H2 console is available at:

```text
http://localhost:8080/kusumika-sms/h2-console
```

## Notes

- The project uses MyBatis mappers and schema/data initialization scripts in `src/main/resources`.
- Database schema and sample data are defined in `src/main/resources/schema.sql` and `src/main/resources/data.sql`.
