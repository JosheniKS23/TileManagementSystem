# TileManagementSystem
Tile Management System in Java_Hackathon_Sem_2


A Java-based console application that simulates inventory and sales management for a tile shop. Users can purchase tiles, update stock levels, and view tile-specific details. The system includes exception handling, profit calculations, and real-time inventory feedback.

## 📌 Features

- **Custom Exceptions**: Handles invalid tile types and insufficient stock using `InvalidTileType` and `InsufficientStock` exceptions.
- **Three Tile Types**:
  - Ceramic
  - Vitrified
  - Marble
- **Inventory Management**:
  - View current tile stock
  - Modify stock quantities
  - Simulate sales
- **Profit Calculation**:
  - Per-sale profit
  - Cumulative daily profit tracking

## 🧱 Tile Attributes

Each tile type includes:
- Area per tile
- Surface finish
- Durability rating
- Application area (Interior/Exterior)
- Stock available
- Selling price (with markup)

## 🧑‍💻 How to Run in Eclipse

1. **Open Eclipse**.
2. **Create a new Java Project**:
   - Go to `File` > `New` > `Java Project`
   - Name it `TileManagementSystem`
3. **Create a package**:
   - Right-click `src` > `New` > `Package`
   - Name it: `hackathon`
4. **Add the Java file**:
   - Right-click on `hackathon` > `New` > `Class`
   - Name it `Question` and paste the entire code into this class file.
5. **Run the Program**:
   - Right-click on `Question.java` > `Run As` > `Java Application`

## 🔄 Sample Workflow

1. **Choose an operation**:
   - 1. Sale
   - 2. Stock Modification
   - 3. Display
2. **Input tile type**: Ceramic, Vitrified, or Marble
3. **View transaction details**: stock levels, cost, and profits.

## ⚠️ Exception Handling

- **InvalidTileType**: Thrown when user inputs an unrecognized tile name.
- **InsufficientStock**: Thrown when the requested tile area exceeds available stock.
- **Warning**: Displayed for large orders (more than 50% of stock).

## 🧑‍🎓 Author

Developed as part of a Java hackathon challenge to demonstrate object-oriented programming overriding and exception handling.

---

> Open to enhancements and contributions!



