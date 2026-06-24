# Priority Broadcast Engine

Technical challenge implementation using Spring Boot, JSF, PrimeFaces, and CompletableFuture.

## Features

- Asynchronous broadcast processing
- Real-time progress tracking
- Customer status monitoring
- Success, Failed, and Pending counters
- PrimeFaces UI with automatic refresh

## Technology Stack

- Java 17
- Spring Boot 3
- JSF (Jakarta Faces)
- PrimeFaces
- Maven

## Project Structure

```text
src/main/java/com/example/broadcasttest
├── bean
├── config
├── model
├── service
│   └── impl
└── BroadcasttestApplication.java

src/main/webapp
└── broadcast.xhtml
```

## How to Run

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

### Open Browser

```text
http://localhost:8080/broadcast.xhtml
```

## Architecture

```text
PrimeFaces UI
      │
      ▼
 BroadcastBean
      │
      ▼
 BroadcastService
      │
      ▼
 MockPhoneNumberService
```

Broadcast processing is executed asynchronously using `CompletableFuture`, allowing the UI to remain responsive while customer statuses are updated in the background.

## Challenge Answers

See:

```text
CHALLENGE_ANSWERS.md
```
