# spring cloud zipkin 

* Zipkin is a distributed tracing system. It gathers timing data. It helps in troubleshooting latency problems in service architecture.

* Feature
    1. lookup of data logs.
    2. storage of logs
    
    3. We can query data using"
        1. Traceid
        2. Service name
        3. operation name
        4. Tags
        5. Duration
    4. Dependency diagram
    
### Download zipkin

* To use zipkin we need to download zipkin and execute it. For download go to zipkin official website
    > https://zipkin.io/
  
* Click on `Quickstart guide`.
* Go to java section and click on `latest release` we will get the executable jar file.
* Then open the command prompt in download location and to execute the jar run the command:
    > java -jar zipkin-server-2.23.18-exec.jar
  
* Once we run the zipkin executable jar we can check it on:
    > http://localhost:9411/zipkin/
  

* We need to  add `spring-cloud-starter-zipkin` and `spring-cloud-starter-sleuth` to export logs in zipkin server.
* To export all the logs in zipkin we should configure zipkin in doctor-portal.

* Now run the application and execute url:
    >http://localhost:7081/doctors
  
* Then we can check the log in zipkin server using:
    >http://localhost:9411/zipkin
  
    where we check logs using service name like `doctor-service` or traceid.

* We can see detail by using traceid. In my case trace id is `d7049007be667f7c` and url to check the details of log is:
    > http://localhost:9411/zipkin/traces/d7049007be667f7c
  > 
* We can check the flow of application in `dependencies` by searching between start time and end time in zipkin.