<h1 align="center">✨ 🛥️ <strong>BattleShip Mini Project - Phase 2</strong> 🛥️ ✨</h1>

<p align="center">
  <i>Level up your programming skills by integrating Object-Oriented Programming principles!</i>
</p>

---

## 📌 **Project Introduction**
Welcome to Phase 2 of the **BattleShip Game** project! In this phase, you'll enhance your previous implementation by applying principles of **Object-Oriented Programming (OOP)**.

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

### ✅ **2. Additional Features**
- **Enhanced Input Validation:** Add more detailed validation messages for better user experience.
- **Replay Feature:** Allow players to restart the game after it ends.
- **Advanced Ship Placement:** Implement a randomized ship placement feature for quicker setup.
- **Dynamic Board Size:** Allow players to choose grid sizes at the beginning of the game.
- **Enhanced AI (Optional):** Create an AI opponent with basic strategy capabilities.
- **Special Attack Moves:** Introduce a limited number of special attacks, such as:
  - **Radar Scan:** Reveals part of the opponent's grid without attacking.
  - **Multi-Strike:** Attacks multiple adjacent cells at once.
- **Ship Health Levels:** Ships may require multiple hits per cell to be fully destroyed (e.g., armored ships).
- **Fog of War:** Players only see parts of the grid they have attacked or scanned.
- **Time-Limited Turns:** Players must act within a set time, or they forfeit the turn.

### ✅ **3. Clean and Modular Code**
- Ensure your code is modular and easy to read.
- Follow good coding practices with well-defined classes and methods.

---

## 🔍 **Why Object-Oriented Programming (OOP)?**
1. **Modularity:** Breaking down the game into classes (like `Game`, `Player`, `Ship`, and `Board`) makes it easier to manage and extend.
2. **Reusability:** Classes and methods can be reused or extended without rewriting existing code.
3. **Scalability:** As the game becomes more complex, OOP makes it easier to add new features.
4. **Maintainability:** Encapsulation keeps different parts of the code independent, reducing bugs and making testing simpler.
5. **Readability:** Clear and organized structure enhances code understanding for future developers.

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

## 🎉 **Final Note**
This is your chance to build a robust, scalable, and engaging game while mastering OOP concepts.

Good luck, have fun coding, and may the best player win! 🚀

🛥 **Happy Coding!**

