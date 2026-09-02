# sb-advnaced-boa
Spring Boot Advanced classroom

Pre Assessment Link: https://forms.cloud.microsoft/r/bYj2WzJNdV


```yaml
resilience4j:
  circuitbreaker:
    instances:
     hr-service-cb:
       registerHealthIndicator: true
       slidingWindowSize: 10
       permittedNumberOfCallsInHalfOpenState: 3
       slidingWindowType: COUNT_BASED
       minimumNumberOfCalls: 2
       waitDurationInOpenState: 10s
       failureRateThreshold: 33.3
       automaticTransitionFromOpenToHalfOpenEnabled: true

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
  health: 
   circuitbreakers:
      enabled: true
```