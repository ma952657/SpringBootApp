# SpringbootApp

**To Run without Docker**

```
> mvn clean install
> java -jar target/springbootdemo-1.0.0-SNAPSHOT.jar
```

**To Run with Docker**
```
> mvn clean install
> docker build -t springbootapp .
> docker run -d -p 8080:8080 springbootapp
> docker stop <image-name>
```
