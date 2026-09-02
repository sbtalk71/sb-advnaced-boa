# Spring Boot Observability Demo Guide

## Overview

This Spring Boot application demonstrates different observability platforms using **Spring Profiles**. Each profile enables only the required configuration for a specific observability solution.

The application can be started with different profiles to demonstrate:

| Profile       | Demonstrates                                                               |
| ------------- | -------------------------------------------------------------------------- |
| `prometheus`  | Metrics collection using Prometheus and Grafana                            |
| `splunk-otlp` | Logs, Metrics and Traces to Splunk Observability Cloud using OpenTelemetry |
| `dynatrace`   | Metrics and Traces to Dynatrace                                            |
| `splunk-uf`   | Log forwarding to Splunk Enterprise using Universal Forwarder              |
| `default`     | Application without any observability integration                          |

---

# Prerequisites

* Java 21+
* Maven 3.9+
* Spring Boot application
* Docker Desktop (recommended)
* Internet connection (for cloud products)

---

# Project Structure

```
application.yml

application-prometheus.yml

application-splunk-otlp.yml

application-dynatrace.yml

application-splunk-uf.yml
```

Each profile contains only the configuration required for that observability platform.

---

# Running the Application

## Method 1 - Maven

```
mvn spring-boot:run -Dspring-boot.run.profiles=prometheus
```

or

```
mvn spring-boot:run -Dspring-boot.run.profiles=splunk-otlp
```

or

```
mvn spring-boot:run -Dspring-boot.run.profiles=dynatrace
```

or

```
mvn spring-boot:run -Dspring-boot.run.profiles=splunk-uf
```

---

## Method 2 - Executable Jar

```
java -jar observability-demo.jar --spring.profiles.active=prometheus
```

Similarly,

```
--spring.profiles.active=splunk-otlp

--spring.profiles.active=dynatrace

--spring.profiles.active=splunk-uf
```

---

# Profile 1 : Prometheus

## Purpose

Demonstrate Micrometer metrics exposed to Prometheus.

## Components

```
Spring Boot
        │
Micrometer
        │
/actuator/prometheus
        │
Prometheus
        │
Grafana
```

## Start Prometheus

```
docker compose up -d
```

(or run your existing Prometheus server)

---

## Verify

Open

```
http://localhost:8080/actuator/prometheus
```

Expected:

Large list of metrics.

---

## Prometheus

```
http://localhost:9090
```

Example queries

```
http_server_requests_seconds_count

jvm_memory_used_bytes

process_cpu_usage

system_cpu_usage

hikaricp_connections
```

---

## Grafana

Open

```
http://localhost:3000
```

Import Micrometer dashboard or create your own.

---

# Profile 2 : Splunk Observability Cloud (OTLP)

## Purpose

Demonstrate

* Metrics
* Traces
* Logs (optional)

using OpenTelemetry.

---

## Architecture

```
Spring Boot

↓

OTLP Exporter

↓

Splunk OpenTelemetry Collector

↓

Splunk Observability Cloud
```

---

## Required Components

* Splunk Observability Cloud Account
* Access Token
* Realm
* Splunk OpenTelemetry Collector

---

## Start Collector

```
docker compose up -d
```

or

```
splunk-otel-collector
```

---

## Run Application

```
spring.profiles.active=splunk-otlp
```

---

## Generate Traffic

Open

```
http://localhost:8080/employees

http://localhost:8080/orders

http://localhost:8080/products
```

or execute Postman collection.

---

## Verify

In Splunk Observability Cloud

### APM

Verify

* Services
* Endpoints
* Traces
* Span Duration

---

### Infrastructure

Verify

* JVM Metrics
* CPU
* Memory
* GC
* Thread Count

---

### Metrics Explorer

Search

```
jvm.memory.used

system.cpu.utilization

process.runtime.jvm.memory.used

http.server.request.duration
```

---

# Profile 3 : Dynatrace

## Purpose

Demonstrate

* Micrometer Metrics
* Distributed Tracing

---

## Architecture

```
Spring Boot

↓

Micrometer Registry

↓

Dynatrace Metrics API

↓

Dynatrace
```

---

## Required

* Dynatrace Tenant
* API Token
* Environment URL

---

## Run

```
spring.profiles.active=dynatrace
```

---

## Verify

Open Dynatrace

Observe

* Services
* Metrics
* Response Time
* JVM Metrics
* Process Metrics

---

Search

```
CPU

Memory

Garbage Collection

Request Count

Response Time
```

---

# Profile 4 : Splunk Enterprise using Universal Forwarder

## Purpose

Demonstrate centralized log collection.

---

## Architecture

```
Spring Boot

↓

application.log

↓

Universal Forwarder

↓

Splunk Enterprise
```

---

## Requirements

* Splunk Enterprise
* Universal Forwarder

---

## Start Splunk

```
docker compose up -d
```

---

## Verify Application Log

```
logs/application.log
```

Logs should be continuously written.

---

## Universal Forwarder

Verify monitored input

```
logs/application.log
```

---

## Splunk Search

Example

```
index=main

source="application.log"
```

Search only application logs

```
index=main

level=INFO
```

Search errors

```
index=main

ERROR
```

---

# Demonstration Flow

## Prometheus

1. Start Prometheus
2. Start Grafana
3. Run application
4. Generate requests
5. Show Actuator metrics
6. Show Prometheus scraping
7. Show Grafana dashboard

---

## Splunk OTLP

1. Start Collector
2. Run application
3. Generate traffic
4. Open APM
5. Show Trace
6. Show Metrics
7. Show Service Map

---

## Dynatrace

1. Run application
2. Generate traffic
3. Open Dynatrace
4. View Services
5. View Metrics
6. View Distributed Trace

---

## Splunk Enterprise + Universal Forwarder

1. Start Splunk Enterprise
2. Start Universal Forwarder
3. Run application
4. Generate logs
5. Search logs
6. Demonstrate indexed log search

---

# Sample Requests

Generate telemetry using:

```
GET /employees

GET /employees/1

POST /employees

PUT /employees/1

DELETE /employees/1
```

Execute requests repeatedly or use Postman Runner/JMeter to produce meaningful metrics and traces.

---

# Expected Output

| Profile                    | Metrics | Traces | Logs                    |
| -------------------------- | ------- | ------ | ----------------------- |
| Prometheus                 | ✅       | ❌      | Console/File            |
| Splunk OTLP                | ✅       | ✅      | Optional (OTLP or file) |
| Dynatrace                  | ✅       | ✅      | Optional                |
| Splunk Universal Forwarder | ❌       | ❌      | ✅                       |

---

# Troubleshooting

| Problem                      | Check                                                                                                           |
| ---------------------------- | --------------------------------------------------------------------------------------------------------------- |
| No Prometheus metrics        | Verify `/actuator/prometheus` and Prometheus scrape configuration                                               |
| No traces in Splunk          | Ensure the OpenTelemetry Collector is running and the OTLP endpoint is correct                                  |
| No metrics in Dynatrace      | Verify the environment URL, API token, and active `dynatrace` profile                                           |
| No logs in Splunk Enterprise | Confirm the application is writing to the expected log file and the Universal Forwarder is monitoring that path |
| Wrong behavior               | Verify the active Spring profile (`spring.profiles.active`) matches the intended demonstration                  |

This guide is suitable as a trainer handout and provides a clear, repeatable workflow for demonstrating each observability stack independently.
