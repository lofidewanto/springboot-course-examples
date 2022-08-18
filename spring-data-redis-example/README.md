# Run Redis within Docker
docker run -p 16379:6379 -d redis:latest redis-server --requirepass "mypass"

... or using Testcontainers included

# This is the config properties for Spring Boot
spring.redis.database=0
spring.redis.host=localhost
spring.redis.port=16379
spring.redis.password=mypass
spring.redis.timeout=60000

# The source article
- https://www.baeldung.com/spring-data-redis-properties
- https://www.baeldung.com/spring-data-redis-tutorial

# Message receiver with @Bean
- https://spring.io/guides/gs/messaging-redis