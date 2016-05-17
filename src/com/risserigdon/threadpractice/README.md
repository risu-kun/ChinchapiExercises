# Thread Practice

This is an exercise with parallel threads, given the following requirements:

* Three threads, A, B and C
* Each thread starts at exactly the same time and concurrently increments the value of some global counter (initially set to 0) by 1 
* Each time a thread increments the value of the counter, it stores new_value in a collection
* After the counter gets to 100, each thread prints out its collection of stored values onto the console
* Once complete, the output of your program should be 100 numbers (1-100) in chronological order followed by three collections, each with a distinct subset of the numbers printed

You can run this on your machine by downloading thread_counter.jar and executing it in your terminal:
``````````
$ java -jar /path/to/thread_counter.jar
``````````