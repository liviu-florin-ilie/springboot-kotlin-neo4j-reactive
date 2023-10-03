# springboot-kotlin-neo4j-reactive

This is a starting point for a springboot appt with kotlin and reactive neo4j.  

The start point for this one is the documentation from here https://neo4j.com/docs/getting-started/languages-guides/java/spring-data-neo4j/

It is not as straightforward as expected so that is why this was created.

## Dependencies

You need to instantiate a neo4j database with docker.

```
docker pull neo4j
```

```
 docker volume create neo4j-data
```

```
docker run \
--name neo4jDB \
--publish=7474:7474 --publish=7687:7687 \
--volume=neo4j-data:/data \
--env NEO4J_ACCEPT_LICENSE_AGREEMENT=yes \
--env NEO4J_AUTH=neo4j/secret1234 \
neo4j:latest
```

You also need to have maven installed.


## Run

```
mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8080'
```

## Lessons learned

1. import statements in spring play a decisive role in @ComponentScanning
2. private values pose a challenge in kotlin
   https://stackoverflow.com/questions/76392714/unable-to-create-a-relationship-with-spring-data-neo4j
   https://stackoverflow.com/questions/65669613/how-do-i-return-relationship-properties-neo4j-spring-data
3. -Dspring-boot.run.jvmArguments='-Dserver.port=8080
4. Logging dependencies https://stackoverflow.com/questions/54652836/slf4j-found-slf4j-api-dependency-but-no-providers-were-found
5. Docker cleanup of volumes
6. Fix project structure in Intellij https://stackoverflow.com/questions/31712046/kotlin-unresolved-reference-in-intellij
7. https://neo4j.com/developer/kb/resolve-port-conflicts-in-neo4j-desktop/
8.  lsof -i :8083
9. Other springboot neo4j examples https://github.com/hantsy/spring-reactive-sample/tree/master/boot-neo4j/src
10. https://hantsy.github.io/spring-reactive-sample/data/data-neo4j-rx.html
   // see: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.4.0-M2-Release-Notes#neo4j-1
11. https://www.callicoder.com/spring-5-reactive-webclient-webtestclient-examples/
12. https://github.com/neo4j-examples/movies-java-spring-data-neo4j/tree/main
13. https://docs.spring.io/spring-data/neo4j/docs/current/reference/html/#sdn.testing
14. https://docs.spring.io/spring-data/neo4j/reference/getting-started.html
15. Configuration problems https://github.com/spring-projects/spring-data-neo4j/issues/2728





