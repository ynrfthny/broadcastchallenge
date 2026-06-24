# Priority Broadcast Engine

## Overview

Priority Broadcast Engine is a simple asynchronous broadcast simulation application built using:

* Spring Boot 3
* Jakarta Faces (JSF)
* PrimeFaces
* CompletableFuture

The application simulates sending broadcast messages to multiple customers concurrently while displaying real-time delivery status and progress updates on the user interface.

---

## Features

### Broadcast Processing

* Simulates message delivery to multiple customers.
* Processes customers asynchronously using `CompletableFuture`.
* Updates customer status in real-time.

### Status Tracking

Each customer can have one of the following statuses:

* PENDING
* PROCESSING
* SUCCESS
* FAILED

### Real-Time Monitoring

* Progress Bar
* Customer Status Table
* Success Counter
* Failed Counter
* Pending Counter

### User Interface

Built using:

* JSF (Jakarta Faces)
* PrimeFaces Components
* AJAX Polling for automatic UI refresh

---

## Technology Stack

| Technology          | Version           |
| ------------------- | ----------------- |
| Java                | 17                |
| Spring Boot         | 3.x               |
| JSF (Jakarta Faces) | 4.x               |
| PrimeFaces          | JoinFaces Starter |
| Maven               | 3.9+              |

---

## Project Structure

```text
src/main/java
│
├── bean
│   └── BroadcastBean.java
│
├── model
│   ├── Customer.java
│   └── BroadcastStatus.java
│
├── service
│   ├── BroadcastService.java
│   └── impl
│       └── BroadcastServiceImpl.java
│
└── BroadcasttestApplication.java
```

### Layer Responsibilities

#### UI Layer

```text
BroadcastBean
```

Responsible for:

* Handling user interactions.
* Providing data to JSF pages.
* Updating progress information.

#### Service Layer

```text
BroadcastService
BroadcastServiceImpl
```

Responsible for:

* Simulating message delivery.
* Managing asynchronous processing.
* Updating customer delivery status.

#### Domain Layer

```text
Customer
BroadcastStatus
```

Responsible for:

* Business data representation.
* Broadcast state management.

---

## How to Run

### Prerequisites

* Java 17
* Maven 3.9+

### Clone Repository

```bash
git clone <repository-url>
cd broadcasttest
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

### Open Application

Navigate to:

```text
http://localhost:8080/broadcast.xhtml
```

---

## How It Works

1. Application loads a sample list of customers.
2. User clicks **Start Priority Broadcast**.
3. Each customer is processed asynchronously using `CompletableFuture`.
4. Customer status changes from:

```text
PENDING
→ PROCESSING
→ SUCCESS / FAILED
```

5. PrimeFaces Poll updates the UI periodically.
6. Progress Bar and statistics are refreshed automatically.

---

## Design Considerations

### Asynchronous Processing

`CompletableFuture` was selected because each broadcast operation is independent and can be executed concurrently without blocking the UI.

### Thread Safety

A `CopyOnWriteArrayList` is used to safely handle concurrent updates while the UI continuously reads customer status information.

### Separation of Concerns

The project follows a simple layered architecture:

```text
JSF Bean
    ↓
Service Layer
    ↓
Broadcast Simulation
```

This keeps presentation logic separate from business logic.

---

## Notes

This project is a technical challenge implementation.

The external messaging provider is simulated and no real SMS, WhatsApp, email, or push notification service is invoked.
