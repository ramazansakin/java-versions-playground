# Java Features Practice

This repository contains exercises and sample code to practice various Java features, including Java 8 and beyond. Each section provides descriptions of the features along with sample code and exercises to help you learn and master them.
JEP: JDK Enhancement Proposal

## Java 8 Features - LTS

- Functional Interfaces
- Lambda Expressions
- Method References
- Stream API
- Optional
- CompletableFuture
- Concurrency Enhancement by Steam API
- Some other improvements


## Java 9 Features

- Private Method usage in Interface
- Java Platform Module System (JPMS) - [Project Jigsaw](https://openjdk.java.net/projects/jigsaw/)
- Collection Factory Methods (List.of, Set.of, Map.of)
- Stream API Enhancements (takeWhile, dropWhile, iterate with predicate, ofNullable)
- Try-With-Resources Enhancement
- HTTP Client API (incubator version)
- JShell - Java REPL


## Java 10 Features

- Local-Variable Type Inference (var keyword)
- Unmodifiable Collections Enhancements (copyOf methods)
- Optional.orElseThrow() Method
- Stream Collectors for Unmodifiable Collections (toUnmodifiableList, toUnmodifiableSet, toUnmodifiableMap)
- G1 Garbage Collector Improvements
- Application Class-Data Sharing
- Time-Based Release Versioning
- Root Certificates
- Heap Allocation on Alternative Memory Devices
- Thread-Local Handshakes


## Java 11 Features - LTS

- String API Enhancements
> - isBlank()
> - lines()
> - strip(), stripLeading(), stripTrailing()
> - repeat()

- HTTP Client API (Standardized from Java 9 incubator)
- Nest-Based Access Control
- Running Java Files Without Compilation (java SourceFile.java)
- Local-Variable Syntax for Lambda Parameters (var)
- Collection.toArray(IntFunction) Method
- Optional.isEmpty() Method
- Predicate.not Method
- Epsilon: A No-Op Garbage Collector
- ZGC: A Scalable Low-Latency Garbage Collector (Experimental)

## Java 12 Features
- Switch Expressions (Preview) (JEP 325) – switch can now be used as an expression.
- Shenandoah GC (JEP 189) – Low-pause-time garbage collector.
- Microbenchmark Suite (JEP 230) – Built-in benchmarking framework.
- One AArch64 Port, Not Two (JEP 340) – Removed redundant ARM 64-bit ports.
- Default CDS Archives (JEP 341) – Improves startup performance by archiving class metadata.
- JVM Constants API (JEP 334) – API for modeling nominal descriptors of key class-file and runtime artifacts.


## Java 13 Features
- Text Blocks (Preview) (JEP 355) – Multi-line string literals using triple quotes (""").
- Switch Expressions (2nd Preview) (JEP 354) – Enhancements to switch as an expression.
- Reimplement Legacy Socket API (JEP 353) – Modernized networking stack.
- Dynamic CDS Archives (JEP 350) – Enhances class data sharing.


## Java 14 New Features
Records (Preview) (JEP 359) – Immutable data classes with auto-generated methods.
Pattern Matching for instanceof (Preview) (JEP 305) – Removes explicit casting after instanceof checks.
Switch Expressions (Final) (JEP 361) – Finalized switch as an expression.
Helpful NullPointerExceptions (JEP 358) – More detailed NullPointerException messages.
JFR Event Streaming (JEP 349) – Continuous JDK Flight Recorder data streaming.
Foreign-Memory Access API (Incubator) (JEP 370) – Efficient access to off-heap memory.
Deprecate the Solaris and SPARC Ports (JEP 362) – Marked for removal.


## Java 15 New Features
- Sealed Classes (Preview) (JEP 360) – Restricting inheritance for classes/interfaces.
- Text Blocks (Final) (JEP 378) – Officially added multi-line strings.
- Hidden Classes (JEP 371) – Allows runtime-only classes for frameworks.
- Pattern Matching for instanceof (2nd Preview) (JEP 375) – Extended pattern matching.
- Foreign-Memory Access API (2nd Incubator) (JEP 383) – Improved off-heap memory access.
- Deprecate RMI Activation (JEP 385) – Marked Remote Method Invocation (RMI) Activation for removal.
- ZGC: A Scalable Low-Latency GC (JEP 377) – Z Garbage Collector became production-ready.


## Java 16 New Features
- Records (Final) (JEP 395) – Officially added immutable data classes.
- Pattern Matching for instanceof (Final) (JEP 394) – Improved type checking.
- Sealed Classes (2nd Preview) (JEP 397) – Further refinements to sealed classes.
- Foreign Linker API (Incubator) (JEP 389) – Simplifies interaction with native code.
- Strongly Encapsulate JDK Internals by Default (JEP 396) – Tightened restrictions on internal APIs.
- Elastic Metaspace (JEP 387) – Reduced memory footprint.
- Vector API (Incubator) (JEP 338) – Introduced SIMD operations for performance boosts.
- Unix-Domain Socket Channels (JEP 380) – Supported inter-process communication.


## Java 17 Features - LTS
- Sealed Classes (JEP 409) – Restricts which classes can extend a given class.
- Pattern Matching for Switch (JEP 406) – Enables type-based pattern matching in switch statements.
- New macOS Rendering Pipeline (JEP 382) – Uses Metal API for better graphics performance on macOS.
- Strongly Encapsulated JDK Internals (JEP 403) – Blocks access to JDK internal APIs.
- Foreign Function & Memory API (Incubator) (JEP 412) – Allows calling native code without JNI.
- Text Blocks (Introduced in Java 13, but LTS in Java 17) – Supports multi-line string literals.
- Records (JEP 395) – Provides immutable data carriers with auto-generated methods.
- Deprecations & Removals:
    - Security Manager removed (JEP 411)
    - RMI Activation removed (JEP 407)
    - Applets removed
