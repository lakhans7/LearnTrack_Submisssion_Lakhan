# JVM Basics

## What is JDK, JRE, and JVM?

### JDK (Java Development Kit)
The **JDK** is a software development kit that includes everything you need to develop Java applications. It contains:
- **JRE** (Java Runtime Environment)
- **Compiler** (javac) - converts Java source code to bytecode
- **Debugger** and other development tools
- **Libraries** and APIs for development

Think of JDK as the complete toolkit for Java developers.

### JRE (Java Runtime Environment)
The **JRE** is a runtime environment that allows you to run Java applications. It includes:
- **JVM** (Java Virtual Machine)
- **Core libraries** and APIs needed to run Java programs
- **Supporting files**

If you only want to run Java programs (not develop them), you only need JRE. However, JDK includes JRE, so if you have JDK installed, you're all set.

### JVM (Java Virtual Machine)
The **JVM** is the engine that executes Java bytecode. It:
- **Loads** bytecode files (.class files)
- **Verifies** the bytecode for security
- **Interprets** or **compiles** bytecode to machine code
- **Executes** the program
- **Manages memory** (garbage collection)

JVM is platform-specific (different JVM for Windows, Linux, macOS), but it runs the same bytecode.

## What is Bytecode?

**Bytecode** is an intermediate representation of your Java code. When you compile a `.java` file using `javac`, it creates a `.class` file containing bytecode.

- Bytecode is **not** human-readable (it's binary)
- Bytecode is **not** machine code (it's not directly executable by the CPU)
- Bytecode is **platform-independent** - the same bytecode runs on any platform that has a JVM

**Example:**
```
Source Code (Hello.java) 
    → javac compiler 
    → Bytecode (Hello.class) 
    → JVM 
    → Machine Code 
    → Execution
```

## What Does "Write Once, Run Anywhere" Mean?

"Write Once, Run Anywhere" (WORA) is Java's key promise. It means:

**You write your Java code once**, compile it to bytecode, and **it can run on any platform** (Windows, Linux, macOS, etc.) **without modification**.

### How It Works:

1. **Write code** in Java (platform-independent)
2. **Compile** to bytecode (platform-independent)
3. **Run** on any platform that has a JVM installed

The JVM acts as a translator between the platform-independent bytecode and the platform-specific machine code. Each platform has its own JVM implementation, but they all understand the same bytecode format.

### Example:
- Write a Java program on Windows
- Compile it to `.class` file
- Copy the `.class` file to a Linux machine
- Run it on Linux using Linux JVM - **it works!**

This is different from languages like C/C++ where you need to compile separately for each platform.

### The Trade-off:
- **Portability**: Write once, run anywhere ✓
- **Performance**: Slight overhead due to JVM interpretation (though modern JVMs use Just-In-Time compilation to optimize this)

