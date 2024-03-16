// Module descriptor for com.example.main
module com.example.main {
    exports org.example.java9;
    requires java.net.http;
}


// Modularity, as it states taht, it is useful for multi-module projects' dependency encapsulation & management
// Classpath Hell: Managing dependencies using the classpath could lead to conflicts between different versions of libraries, resulting in runtime errors that are hard to diagnose.
// Visibility Issues: All classes on the classpath were visible to all other classes, leading to potential encapsulation violations and accidental usage of internal APIs.
// Security Concerns: Lack of strong encapsulation could lead to security vulnerabilities, as classes could access and modify internal state of other classes.