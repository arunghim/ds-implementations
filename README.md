# Java Data Structures Library

A comprehensive collection of **custom Java data structure implementations** designed for learning, experimentation, and testing fundamental abstract data types (ADTs).  
This project includes multiple implementations of each interface, showcasing different design strategies and underlying data structures.

---

## Project Structure

````
ds/
├── map/
│ ├── IMap.java // Map Interface
│ ├── Map1.java // HashMap-Based Map
│ ├── Map2.java // Dual Queue-Backed Map
│ ├── Map3.java // Bucketed Hash Map
│ └── Map4.java // BST-Backed Map
│
├── queue/
│ ├── IQueue.java // Queue Interface
│ ├── Queue1.java // ArrayList-Based Queue
│ ├── Queue2.java // LinkedList-Based Queue
│ └── Queue3.java // Sequence-Backed Queue
│
├── sequence/
│ ├── ISequence.java // Sequence Interface
│ ├── Sequence1.java // ArrayList-Based Sequence
│ ├── Sequence2.java // LinkedList-Based Sequence
│ └── Sequence3.java // Two-Stack Sequence
│
├── set/
│ ├── ISet.java // Set Interface
│ ├── Set1.java // ArrayList-Based Set
│ ├── Set2.java // HashMap-Backed Set
│ ├── Set3.java // BinaryTree-Backed Set
│ └── Set4.java // Custom Hash-Bucket Set
│
├── stack/
│ ├── IStack.java // Stack Interface
│ ├── Stack1.java // ArrayList-Based Stack
│ ├── Stack2.java // LinkedList-Based Stack
│ └── Stack3.java // Sequence-Backed Stack
│
└── tree/
  ├── ITree.java // Tree Interface
  ├── Node.java // Tree Node Structure
  ├── BinaryTree.java // Level-Order Binary Tree
  └── BinarySearchTree.java // Ordered Binary Search Tree
````

---

## Features

- **Generic and Type-Safe:** All implementations use **Java Generics** to ensure type safety and flexibility.
- **Interface-First Design:** Clear separation of interfaces and implementations for **abstraction, modularity, and easy swapping** of data structures.
- **Map Operations:** Supports `put`, `get`, `remove`, `containsKey`, `containsValue`, `keySet`, `size`, and `isEmpty`, with multiple underlying implementations.
- **Tree Operations:** Supports `insert`, `remove`, `contains`, `findMin`, `findMax`, and **in-order traversal** for both general binary trees and binary search trees.
- **Set Operations:** Supports `add`, `remove`, and `contains`, with **dynamic resizing** in hash-based set implementations.
- **Queue & Stack Operations:** Standard methods like `offer`/`poll`/`peek` for queues and `push`/`pop`/`peek` for stacks.
- **Sequence Operations:** Provides `add`, `remove`, and `entry` at any position, with multiple underlying implementations for **performance comparison**.

---

## Interfaces & Implementations

| Category | Interface      | Implementations                       |
|----------|----------------|---------------------------------------|
| Map      | `IMap<K,V>`    | `Map1`, `Map2`, `Map3`, `Map4`        |
| Queue    | `IQueue<T>`    | `Queue1`, `Queue2`, `Queue3`          |
| Sequence | `ISequence<T>` | `Sequence1`, `Sequence2`, `Sequence3` |
| Set      | `ISet<T>`      | `Set1`, `Set2`, `Set3`, `Set4`        |
| Stack    | `IStack<T>`    | `Stack1`, `Stack2`, `Stack3`          |
| Tree     | `ITree<T>`     | `BinaryTree`, `BinarySearchTree`      |