## Gateway-Server-wrk-Record

#### Serial
````
java -jar -XX:+PrintGCDetails -XX:+UseSerialGC -Xms1024M -Xmx1024M gateway-server-0.0.1-SNAPSHOT.jar
sheng:~ shiyuesheng$ wrk -t8 -c40 -d60s http://localhost:8088/api/hello
Running 1m test @ http://localhost:8088/api/hello
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    20.67ms   45.29ms 515.02ms   90.18%
    Req/Sec     0.90k   429.84     2.41k    66.69%
  427849 requests in 1.00m, 51.08MB read
Requests/sec:   7121.66
Transfer/sec:      0.85MB
````

#### ParNew
````
java -jar -XX:+PrintGCDetails -XX:+UseParNewGC -Xms1024M -Xmx1024M gateway-server-0.0.1-SNAPSHOT.jar
sheng:~ shiyuesheng$ wrk -t8 -c40 -d60s http://localhost:8088/api/hello
Running 1m test @ http://localhost:8088/api/hello
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    17.20ms   38.04ms 531.93ms   90.42%
    Req/Sec     1.02k   406.90     2.42k    63.57%
  483404 requests in 1.00m, 57.71MB read
Requests/sec:   8043.80
Transfer/sec:      0.96MB
````

#### PS
````
java -jar -XX:+PrintGCDetails -XX:+UseParallelGC -Xms1024M -Xmx1024M gateway-server-0.0.1-SNAPSHOT.jar
sheng:~ shiyuesheng$ wrk -t8 -c40 -d60s http://localhost:8088/api/hello
Running 1m test @ http://localhost:8088/api/hello
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    16.38ms   39.96ms 637.68ms   91.24%
    Req/Sec     1.26k   606.52     3.97k    60.26%
  595926 requests in 1.00m, 71.15MB read
Requests/sec:   9918.60
Transfer/sec:      1.18MB
````

#### CMS
````
java -jar -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms1024M -Xmx1024M gateway-server-0.0.1-SNAPSHOT.jar
sheng:~ shiyuesheng$ wrk -t8 -c40 -d60s http://localhost:8088/api/hello
Running 1m test @ http://localhost:8088/api/hello
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.50ms   16.65ms 397.55ms   96.61%
    Req/Sec     2.45k   643.02    13.40k    63.91%
  1168682 requests in 1.00m, 139.53MB read
Requests/sec:  19449.87
Transfer/sec:      2.32MB
````

#### G1
````
java -jar -XX:+PrintGCDetails -XX:+UseG1GC -Xms1024M -Xmx1024M gateway-server-0.0.1-SNAPSHOT.jar
sheng:~ shiyuesheng$ wrk -t8 -c40 -d60s http://localhost:8088/api/hello
Running 1m test @ http://localhost:8088/api/hello
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.50ms   11.53ms 263.03ms   95.53%
    Req/Sec     2.10k   632.21     4.54k    60.71%
  1003775 requests in 1.00m, 119.84MB read
Requests/sec:  16709.78
Transfer/sec:      1.99MB
````