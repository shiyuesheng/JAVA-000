## IO-wrk-Record
物理环境：双核Intel Core i5、JVM（Xmx2048M）

#### 单线程socket
````
单线程socket - 8线程压测
wrk -t8 -c40 -d30s http://localhost:8801
Running 30s test @ http://localhost:8801
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   906.91ms   99.36ms 973.93ms   96.59%
    Req/Sec     8.57      8.57    30.00     74.01%
  881 requests in 30.10s, 84.76KB read
  Socket errors: connect 0, read 1236, write 64, timeout 0
Requests/sec:     29.27
Transfer/sec:      2.82KB

单线程socket - 16线程压测
wrk -t16 -c40 -d30s http://localhost:8801
Running 30s test @ http://localhost:8801
  16 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   729.11ms   73.29ms 770.30ms   96.96%
    Req/Sec     2.17      2.61    19.00     88.70%
  823 requests in 30.10s, 80.63KB read
  Socket errors: connect 0, read 1253, write 42, timeout 0
Requests/sec:     27.34
Transfer/sec:      2.68KB

单线程socket - 24线程压测
wrk -t24 -c40 -d30s http://localhost:8801
Running 30s test @ http://localhost:8801
  24 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   547.29ms   52.84ms 575.88ms   97.22%
    Req/Sec     0.72      0.82    10.00     97.77%
  719 requests in 30.10s, 73.62KB read
  Socket errors: connect 0, read 1270, write 25, timeout 0
Requests/sec:     23.89
Transfer/sec:      2.45KB
````

#### 多线程socket
````
多线程socket - 8线程压测
wrk -t8 -c40 -d30s http://localhost:8802
Running 30s test @ http://localhost:8802
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    25.59ms   10.53ms 169.00ms   99.46%
    Req/Sec    31.16     17.00   161.00     63.19%
  7357 requests in 30.10s, 1.67MB read
  Socket errors: connect 0, read 47415, write 26, timeout 0
Requests/sec:    244.44
Transfer/sec:     56.81KB

多线程socket - 16线程压测
wrk -t16 -c40 -d30s http://localhost:8802
Running 30s test @ http://localhost:8802
  16 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    25.03ms    5.63ms 114.18ms   98.81%
    Req/Sec    15.45      9.96    60.00     72.55%
  6655 requests in 30.11s, 1.40MB read
  Socket errors: connect 0, read 38488, write 15, timeout 0
Requests/sec:    221.05
Transfer/sec:     47.51KB

多线程socket - 24线程压测
wrk -t24 -c40 -d30s http://localhost:8802
Running 30s test @ http://localhost:8802
  24 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    24.39ms    6.12ms 118.37ms   99.51%
    Req/Sec     9.67      6.58    40.00     67.04%
  5484 requests in 30.10s, 1.11MB read
  Socket errors: connect 0, read 29615, write 9, timeout 0
Requests/sec:    182.17
Transfer/sec:     37.83KB
````

#### 线程池socket
````
线程池socket - 8线程压测
wrk -t8 -c40 -d30s http://localhost:8803
Running 30s test @ http://localhost:8803
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    24.68ms    8.02ms 129.88ms   97.81%
    Req/Sec    19.57     13.72   108.00     80.10%
  4250 requests in 30.10s, 1.35MB read
  Socket errors: connect 0, read 49481, write 12, timeout 0
Requests/sec:    141.18
Transfer/sec:     46.07KB

线程池socket - 16线程压测
wrk -t16 -c40 -d30s http://localhost:8803
Running 30s test @ http://localhost:8803
  16 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    24.66ms    7.40ms 113.40ms   98.48%
    Req/Sec    11.01      7.92    60.00     64.32%
  4220 requests in 30.10s, 1.16MB read
  Socket errors: connect 0, read 39246, write 17, timeout 0
Requests/sec:    140.19
Transfer/sec:     39.53KB

线程池socket - 24线程压测
wrk -t24 -c40 -d30s http://localhost:8803
Running 30s test @ http://localhost:8803
  24 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    24.31ms    6.39ms 111.01ms   98.82%
    Req/Sec     7.69      6.36    50.00     77.32%
  3728 requests in 30.11s, 0.95MB read
  Socket errors: connect 0, read 29877, write 6, timeout 0
Requests/sec:    123.83
Transfer/sec:     32.15KB
````

#### netty
````
netty - 8线程压测
wrk -t8 -c40 -d30s http://localhost:8808/test
Running 30s test @ http://localhost:8808/test
  8 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    25.54ms   13.98ms 279.74ms   99.00%
    Req/Sec   204.82     20.56   252.00     83.81%
  48724 requests in 30.10s, 5.06MB read
Requests/sec:   1618.54
Transfer/sec:    172.29KB

netty - 16线程压测
wrk -t16 -c40 -d30s http://localhost:8808/test
Running 30s test @ http://localhost:8808/test
  16 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    25.65ms   17.45ms 344.41ms   99.19%
    Req/Sec    82.38      8.32   101.00     86.74%
  39224 requests in 30.10s, 4.08MB read
Requests/sec:   1303.20
Transfer/sec:    138.72KB

netty - 24线程压测
wrk -t24 -c40 -d30s http://localhost:8808/test
Running 30s test @ http://localhost:8808/test
  24 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    24.89ms   10.95ms 273.13ms   99.51%
    Req/Sec    41.07      4.66    50.00     80.17%
  29528 requests in 30.09s, 3.07MB read
Requests/sec:    981.42
Transfer/sec:    104.47KB
````