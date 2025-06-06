# 🎮 Tic Tac Toe - Low Level Design

A clean, interview-ready, object-oriented implementation of the classic Tic Tac Toe game, demonstrating core LLD principles and design best practices.

---

## 📋 Problem Statement

**Design and implement a Tic Tac Toe game using object-oriented principles, making it extensible and robust for interview-level discussions.**  
Requirements include both Player-vs-Player and Player-vs-Computer modes, with scalable code and clear separation of concerns.

---

## 📝 Functional Requirements

- Two players take alternate turns.
- The game board is a 3x3 grid (can be extended to N x N).
- Each player marks a cell with their symbol (X or O).
- After every move, the system checks for a win or draw.
- The system displays the board after every move.
- The game announces the winner or a draw.
- Option to play against a computer (with simple AI for now).

---

## 🚦 Non-Functional Requirements

- Clean, modular, and object-oriented code.
- Clear encapsulation and abstraction.
- Easily extensible for larger boards or smarter AI.
- All user input and output handled via console.
- Easy to add new features (e.g., undo, multiple board sizes, advanced AI).

---

## 📦 Class Diagram

[Tic Tac Toe UML Class Diagram]
<img width="1071" alt="image" src="https://github.com/user-attachments/assets/3dbfcc45-49f1-47f1-96fa-880fa8f9e387" />


---

## 🧩 Main Components

| Class            | Responsibility                                                             |
|------------------|----------------------------------------------------------------------------|
| `Board`          | Maintains board state, validates moves, and displays the board.            |
| `Player`         | Abstract base class for all players (human or computer).                   |
| `HumanPlayer`    | Handles human move input.                                                  |
| `ComputerPlayer` | Contains simple AI logic for computer moves.                               |
| `GameController` | Manages game flow, player switching, move validation, and win checking.    |
| `Move`           | Encapsulates a single move (row, column).                                  |
| `Symbol`         | Enum for player symbols (X or O).                                          |
| `EventType`      | Enum for game events (WIN, DRAW, INPROGRESS).                              |
| `PlayerFactory`  | Factory for creating player instances based on type.                       |
| `Main`           | Entry point for the application.                                           |

---
