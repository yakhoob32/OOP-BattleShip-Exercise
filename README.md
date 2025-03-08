# ✨ 🛥️ **BattleShip Exercise - Phase 2** 🛥️ ✨

<p align="center">
  <i>Level up your programming skills by integrating Object-Oriented Programming principles!</i>
</p>

---

## 📌 **Exercise Introduction**
Welcome to Phase 2 of the **BattleShip Game** exercise! In this phase, you'll enhance your previous implementation by applying principles of **Object-Oriented Programming (OOP)**.

> 🎯 **Objective:** Develop a more maintainable, scalable, and modular version of the game by utilizing core OOP concepts.

---

## 🎮 **Game Rules (Same as Phase 1)**

### 🎲 **1. Game Board**
- The game uses a **10x10 grid** for each player.
- Rows are labeled with numbers (`0 to 9`) and columns with letters (`A to J`).

### 🛥️ **2. Ship Placement**
- Players place their ships on the grid.
- Ships can be positioned **horizontally** or **vertically**.
- Ships must **not overlap** or go out of bounds.

### 🛣️ **3. Types of Ships**
| 🛥 **Ship Type**      | ✂️ **Size (Cells)** |
|----------------------|--------------------|
| 🛥 Aircraft Carrier   | 5                  |
| 🛥 Battleship         | 4                  |
| 💧 Submarine          | 3                  |
| ⚓ Patrol Boat         | 2                  |

### 🎯 **4. Gameplay Mechanics**
- Players take turns entering target coordinates (e.g., `B5`).
- Possible outcomes:
  - **Hit:** Part of a ship is hit.
  - **Miss:** No ship is hit.
  - **Ship Sunk:** All parts of a ship are destroyed.

### 🏆 **5. Winning Condition**
- The first player to sink **all opponent ships** wins the game.

---

## 🔧 **Required Features for Phase 2**

### ✅ **1. Object-Oriented Design**
- Implement the game using classes to encapsulate game components.
- Use principles like **encapsulation**, **inheritance**, and **polymorphism** where appropriate.

### ✅ **2. Additional Features (with Java Implementation)**

#### **Enhanced Input Validation**
```java
import java.util.Scanner;

public class InputValidator {
    public static boolean isValidCoordinate(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }
}
```

#### **Replay Feature**
```java
import java.util.Scanner;

public class Game {
    public void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }
    
    private boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equalsIgnoreCase("yes");
    }

    private void playGame() {
        System.out.println("Game logic here...");
    }
}
```

#### **Advanced Ship Placement (Randomized)**
```java
import java.util.Random;

public class ShipPlacer {
    public static void placeShipRandomly(Board board, Ship ship) {
        Random rand = new Random();
        boolean placed = false;
        while (!placed) {
            int row = rand.nextInt(board.getSize());
            int col = rand.nextInt(board.getSize());
            boolean horizontal = rand.nextBoolean();
            placed = board.placeShip(ship, row, col, horizontal);
        }
    }
}
```

#### **Dynamic Board Size**
```java
public class Board {
    private char[][] grid;
    private int size;
    
    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
    }
    
    public int getSize() {
        return size;
    }
}
```

#### **Enhanced AI (Basic Strategy)**
```java
import java.util.Random;

public class AIPlayer extends Player {
    public String makeMove() {
        Random rand = new Random();
        return "" + (char) ('A' + rand.nextInt(10)) + rand.nextInt(10);
    }
}
```

#### **Special Attack Moves**
```java
public class SpecialAttack {
    public static void radarScan(Board enemyBoard) {
        System.out.println("Radar scan activated!");
    }
    
    public static void multiStrike(Board enemyBoard, int row, int col) {
        System.out.println("Multi-Strike attack!");
    }
}
```

---
Suggested Class Structure
Game – Manages the flow of the game.
Player – Represents a player (both human and AI).
Board – Represents the grid of the game (10x10).
Ship – Represents a ship and its properties.
InputValidator – Validates the coordinates.
ShipPlacer – Handles placing ships on the board (randomized or manual).
SpecialAttack – Contains special attack logic (e.g., radar scan).
AIPlayer – AI-specific behavior to make moves.
1. Game Class (Manages the Flow of the Game)
java
Copy
Edit
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    public Game() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
    }

    public void start() {
        boolean playAgain;
        do {
            System.out.println("Starting a new game...");
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }

    private void playGame() {
        // Initialize game, ship placements, and game mechanics.
        System.out.println("Game logic here...");
    }

    private boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equalsIgnoreCase("yes");
    }
}
2. Player Class (Represents Each Player)
java
Copy
Edit
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Board board;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.board = new Board(10);  // 10x10 grid
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean hasLost() {
        return ships.stream().allMatch(Ship::isSunk);
    }
}
3. Board Class (The Game Grid)
java
Copy
Edit
public class Board {
    private char[][] grid;

    public Board(int size) {
        this.grid = new char[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '~';  // Represents water
            }
        }
    }

    public void placeShip(Ship ship, int row, int col, boolean horizontal) {
        // Logic for placing the ship on the board
    }

    public void displayBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
4. Ship Class (Defines Ships and Their Properties)
java
Copy
Edit
public class Ship {
    private String name;
    private int size;
    private int hits;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.hits = 0;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits == size;
    }
}
5. InputValidator Class (Handles User Input Validation)
java
Copy
Edit
public class InputValidator {
    public static boolean isValidCoordinate(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }
}
6. ShipPlacer Class (Handles Ship Placement Logic)
java
Copy
Edit
import java.util.Random;

public class ShipPlacer {
    public static void placeShipRandomly(Board board, Ship ship) {
        Random rand = new Random();
        boolean placed = false;
        while (!placed) {
            int row = rand.nextInt(board.getSize());
            int col = rand.nextInt(board.getSize());
            boolean horizontal = rand.nextBoolean();
            placed = board.placeShip(ship, row, col, horizontal);
        }
    }
}
7. SpecialAttack Class (For Special Attacks like Radar Scan or Multi-Strike)
java
Copy
Edit
public class SpecialAttack {
    public static void radarScan(Board enemyBoard) {
        System.out.println("Radar scan activated!");
        // Implement radar scan logic
    }

    public static void multiStrike(Board enemyBoard, int row, int col) {
        System.out.println("Multi-Strike attack on " + (char) ('A' + col) + row + "!");
        // Implement multi-strike logic
    }
}
8. AIPlayer Class (For AI Behavior)
java
Copy
Edit
import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    public String makeMove() {
        Random rand = new Random();
        char col = (char) ('A' + rand.nextInt(10));
        int row = rand.nextInt(10);
        return "" + col + row;
    }
}
Additional Notes
The Board class uses a simple 2D array (char[][] grid) for the game grid.
The Ship class tracks the number of hits and checks whether it has been sunk.
AIPlayer makes random moves, but you can enhance the AI logic for smarter decision-making.
The InputValidator ensures that players input coordinates in the correct format (A0, B9, etc.).
ShipPlacer randomizes ship placement.
SpecialAttack includes special moves, like radar scans, which can be expanded based on your requirements.
Example of the Main Game Loop
java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
---

## 🚀 **Git Workflow for Submitting the Exercise**

To complete and submit this exercise, follow these Git steps:

### **1. Fork the Repository**
Go to the following repository and click the **Fork** button:
🔗 [https://github.com/AP4032/OOP-BattleShip-Exercise](https://github.com/AP4032/OOP-BattleShip-Exercise)

### **2. Clone Your Fork**
```sh
git clone https://github.com/YOUR_USERNAME/OOP-BattleShip-Exercise.git
```

### **3. Implement Your Code**
- Write the necessary classes and methods.
- Commit changes after completing each feature.

```sh
git add .
git commit -m "Added Ship class implementation"
```

### **4. Push Changes to Your Fork**
```sh
git push
```

### **5. Create a Pull Request**
- Go to your forked repository on GitHub.
- Click the **New Pull Request** button.
---

## 🎉 **Final Note**
This is your chance to build a robust, scalable, and engaging game while mastering OOP concepts.

Good luck, have fun coding, and may the best player win! 🚀

🛥 **Happy Coding!**

