# Directed Acyclic Graph Practice

Implement a [directed acyclic graph](https://en.wikipedia.org/wiki/Directed_acyclic_graph) in Java given the following requirements:

* Add an edge from a `source` node to a `destination` node and return `true` if the edge is added
* If either `source` or `destination` does not exist, create it before adding the edge

Tests can be run by executing DAGTestRunner.jar:
```````
$ java -jar /path/to/DAGTestRunner.jar
```````

### The tests `setUp()` the following graph:
![Initial graph](https://github.com/risu-kun/JavaExercises/blob/master/initial-test-graph.png)


### Successful creation of a valid edge between `B` and `E` is asserted
![Valid edge creation](https://github.com/risu-kun/JavaExercises/blob/master/attempt-valid-edge-creation.png)

### An edge between `F` and `A` should not be created, because it results in a cycle
![Invalid edge creation](https://github.com/risu-kun/JavaExercises/blob/master/invalid-edge-creation.png)