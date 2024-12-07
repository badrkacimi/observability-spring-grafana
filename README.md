# Observability with Spring Boot and Grafana

This project demonstrates how to implement observability in a Spring Boot application using Grafana, Prometheus, Loki, and Tempo for metrics, logs, and traces.

## Prerequisites

- **Docker**: Ensure Docker is installed on your system.
- **Docker Compose**: Required for orchestrating the observability stack.

## Getting Started

### Clone the Repository

```
git clone https://github.com/badrkacimi/observability-spring-grafana.git
cd observability-spring-grafana
```
Build the Application

```
./mvnw clean install
```
Start the Observability Stack
```
docker-compose up -d
```
This will start the following services:

```
Prometheus: http://localhost:9090
Grafana: http://localhost:3000
Loki: http://localhost:3100
Tempo: http://localhost:3200
```
### Access Grafana

Open http://localhost:3000 in your browser.
Log in with the default credentials:
Username: admin
Password: admin

Configure data sources for Prometheus, Loki, and Tempo to start visualizing metrics, logs, and traces.

Application Endpoints
```
Metrics: http://localhost:8080/actuator/prometheus
Health Check: http://localhost:8080/actuator/health
```

Generating Load
To simulate load and generate observability data:

Run the application:
```
./mvnw spring-boot:run
```

### Visualizing Data

Metrics: Use Prometheus and Grafana to monitor application metrics.
Logs: Access application logs via Grafana (Loki integration).
Traces: View request traces through Tempo in Grafana.

### Cleanup
To stop and remove all services:
```
docker-compose down
```

### References
Spring Boot Observability with Grafana
SpringBoot Observability 

### Feel free to contribute to this project by creating pull requests or opening issues for suggestions and improvements!

