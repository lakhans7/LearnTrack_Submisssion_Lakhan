# Setup Instructions

## JDK Version Used

**JDK Version:** Java 17 (or any JDK 8+)

To check your Java version, run:
```bash
java -version
javac -version
```

## Installation Steps

### 1. Install JDK

If you don't have JDK installed:

**Windows:**
- Download JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
- Run the installer and follow the instructions
- Add Java to your PATH environment variable

**macOS:**
```bash
brew install openjdk@17
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### 2. Verify Installation

Open a terminal/command prompt and run:
```bash
java -version
javac -version
```

You should see output showing your Java version.

### 3. Set Up Project

1. Navigate to the project directory:
```bash
cd LearnTrack_Submisssion_Lakhan
```

2. Create a `bin` directory for compiled classes (optional):
```bash
mkdir bin
```

### 4. Compile the Project

**Option 1: Compile all files at once**
```bash
javac -d bin -sourcepath src src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/*.java
```

**Option 2: Compile from src directory**
```bash
cd src
javac com/airtribe/learntrack/**/*.java com/airtribe/learntrack/*.java
```

### 5. Run the Application

**If compiled to bin directory:**
```bash
java -cp bin com.airtribe.learntrack.Main
```

**If compiled in src directory:**
```bash
java -cp src com.airtribe.learntrack.Main
```

## Hello World Example

To verify your setup works, create a simple test:

**Create Test.java:**
```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

**Compile:**
```bash
javac Test.java
```

**Run:**
```bash
java Test
```

**Expected Output:**
```
Hello World!
```

## Troubleshooting

### Issue: 'javac' is not recognized
**Solution:** Add JDK's bin directory to your PATH environment variable.

### Issue: ClassNotFoundException
**Solution:** Make sure you're running from the correct directory and using the correct classpath (-cp).

### Issue: Compilation errors
**Solution:** Ensure all source files are in the correct package structure and all dependencies are present.

## IDE Setup (Optional)

### IntelliJ IDEA
1. File → Open → Select project folder
2. Mark `src` as Sources Root
3. Right-click `Main.java` → Run

### Eclipse
1. File → Import → Existing Projects into Workspace
2. Select project folder
3. Right-click `Main.java` → Run As → Java Application

### VS Code
1. Install Java Extension Pack
2. Open project folder
3. Open `Main.java` and click Run

