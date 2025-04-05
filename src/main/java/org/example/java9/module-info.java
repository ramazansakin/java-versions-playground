// 1. Java Platform Module System (JPMS)
// module-info.java file example
module com.example.myapp {
    requires java.logging;
    requires java.sql;
    requires java.net.http;
    requires jdk.httpserver;
    exports org.example.java8.streams;
    // provides org.example.TaskService with org.example.impl.TaskServiceImpl;
}

// Modularity, as it states that, it is useful for multi-module projects' dependency encapsulation & management

// Classpath Hell: Managing dependencies using the classpath could lead to conflicts between different versions
// of libraries, resulting in runtime errors that are hard to diagnose.

// Visibility Issues: All classes on the classpath were visible to all other classes, leading to potential encapsulation
// violations and accidental usage of internal APIs.

// Security Concerns: Lack of strong encapsulation could lead to security vulnerabilities, as classes could access
// and modify internal state of other classes.