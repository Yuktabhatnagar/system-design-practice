# System Design Practice

Java examples for low-level design, design patterns, SOLID principles, and concurrency practice.

## Project Layout

```text
.
├── docs/
│   └── uml/                         PlantUML diagrams for selected topics
├── src/
│   ├── main/java/com/yukta/systemdesign/
│   │   ├── Main.java
│   │   └── lld/
│   │       ├── dependencyinjection/  Dependency injection examples
│   │       ├── designpatterns/       Creational, structural, and behavioral patterns
│   │       ├── multithreading/       Core threading, executors, locks, futures, and concurrency collections
│   │       ├── softwaredesignprinciples/
│   │       └── solid/                SOLID principle examples
│   └── test/java/com/yukta/systemdesign/
│       └── lld/                      Focused JUnit tests for selected examples
└── build.gradle                      Gradle Java project configuration
```

## Requirements

- JDK 21
- Gradle wrapper included in this repository

## Common Commands

Run all tests:

```bash
./gradlew test
```

On Windows PowerShell:

```powershell
.\gradlew.bat test
```

Compile the project:

```bash
./gradlew build
```

Run a demo class from the IDE by opening the class and running its `main` method.

## Suggested Learning Path

1. Start with `lld/solid` to understand the design principles behind the examples.
2. Continue with `lld/softwaredesignprinciples` for broader engineering principles such as DRY, KISS, and YAGNI.
3. Move to `lld/designpatterns/creational`, then `structural`, then `behavioural`.
4. Study `lld/dependencyinjection` once factories and abstractions are clear.
5. Work through `lld/multithreading` from core threading to executors, locks, futures, and modern Java concurrency.
6. Use `docs/uml` alongside code when a topic benefits from a class diagram.

## Documentation

UML diagrams are available in `docs/uml`. They use PlantUML and can be rendered with:

```bash
plantuml docs/uml/*.puml
```

## Testing Approach

This repository is example-heavy, so not every demo class needs a test. Prefer tests for examples that model reusable behavior, such as factories, state transitions, strategies, observers, calculators, and thread-safe utilities.
