# Java CLI Applications

This project contains simple command-line applications written in Java:

- **BasicCalculator**: Perform basic arithmetic operations.
- **TicTacToe**: Play a two-player Tic-Tac-Toe game.
- **TodoListApp**: Manage a to-do list.

- All apps are interactive and require terminal input.
- For robustness, only valid integer inputs are accepted for menu/task/board positions; invalid input may cause the app to terminate.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (for building the project)
- A terminal or command prompt
- Git (for cloning the repository)

## Getting Started
1. **Clone the Repository**:
   ```bash
    git clone git@github.com:sana-khan-gh/trickytriple.git
    cd trickytriple
    ```

2. **Build the Project**
    ```bash
    mvn clean install
    ```
   
### **Run the Applications**:

- **Basic Calculator**:
```bash
mvn exec:java -Dexec.mainClass="org.example.application.cli.BasicCalculator"
```

- **Tic Tac Toe**:
```bash
mvn exec:java -Dexec.mainClass="org.example.application.cli.TicTacToe"
```

- **Todo List App**:
```bash
mvn exec:java -Dexec.mainClass="org.example.application.cli.TicTacToe"
```

