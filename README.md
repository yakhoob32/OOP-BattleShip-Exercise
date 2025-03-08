<h1 align="center">✨ 🛥️ <strong>BattleShip Exercise - Phase 2</strong> 🛥️ ✨</h1>
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
## 📊 **Suggested Class Structure**
 
 ### **1. `Game`**
 - Manages the main game flow, turn order, and win conditions.
 - Handles game initialization and replay functionality.
 
 ### **2. `Player`**
 - Stores player information, including the game board and ships.
 - Manages player moves and interactions.
 
 ### **3. `Board`**
 - Manages the player’s grid and keeps track of hits, misses, and ship positions.
 - Displays the board status.
 
 ### **4. `Ship`**
 - Handles properties like size, position, health levels, and damage tracking.
 - Manages ship-specific logic.
 
 ### **5. `Coordinate`**
 - Encapsulates a grid position for easy reference.
 - Handles validation and parsing of coordinates.
 
 ### **6. `SpecialAttack` (Optional)**
 - Handles logic for special moves like radar scans and multi-strikes.
 
 ### **7. `Utils`**
 - Provides helper functions for input validation, game status updates, and board display.
 
 ---
 
 ## 👨‍💻 **Development Tips**
 - Write **clean, modular, and readable code**.
 - Apply OOP principles thoughtfully.
 - Test thoroughly to catch and resolve bugs.
 - Use comments to clarify key parts of your code.
 - Keep classes focused on single responsibilities.
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

