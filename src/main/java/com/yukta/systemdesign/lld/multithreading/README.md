# Multithreading

Examples for Java threading and concurrency concepts:

- `core_threading`: thread creation, lifecycle, synchronization, volatile, atomics, deadlock, starvation, and thread interaction
- `executors`: executor services, thread pools, scheduled executors, and fork-join examples
- `lock`: explicit lock examples including reentrant, read-write, stamped, and semaphore-based locking
- `modern_java_concurrency`: callable, future, completable future, async programming, thread-local, and virtual thread examples
- `collection_and_concurrency`: concurrent collections and producer-consumer variants

Concurrency examples can be nondeterministic by nature. When adding tests, prefer deterministic units such as counters, state transitions, pool limits, or timeout behavior.
