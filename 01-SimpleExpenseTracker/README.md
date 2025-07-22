# 💸 SimpleExpenseTracker

A lightweight Java console-based application for tracking expenses and monthly budgets.  
Built as a hands-on learning project with **clear separation of concerns** using a **4-layer architecture** and simple Java serialization for persistence.

Took around 1:30 hours to make without AI

---

## 🧱 Architectural Overview (4-Layered)

This project follows a clean modular structure for maintainability and scalability:

| Layer            | Responsibility                                      |
|------------------|-----------------------------------------------------|
| **Presentation** | CLI UI, input/output, menus, user feedback          |
| **Application**  | Business logic, service orchestration               |
| **Domain**       | Core entities/models (Expense, Budget)              |
| **Infrastructure** | Persistence (save/load to disk via serialization) |

---

## 📂 Folder Structure
    C:.
    ├───src
    │ ├───Application # Core logic (ExpenseTracker class)
    │ ├───Domain # Models (Expense.java, Budget.java)
    │ ├───Infrastructure # Persistence (StorageHelper.java)
    │ └───Presentation
    │ └───Helpers # Menu handling, input validation

---

## ✅ Features

- 🧾 Add and view categorized expenses
- 💰 Set monthly budgets per category
- 📊 Generate real-time spending reports with warnings
- 💾 Data persistence using native Java serialization

---

## ▶️ How to Run

### 🔧 Prerequisites
- Java JDK 17+ (or any version supporting `java.time`)
- IDE like IntelliJ or VS Code (or compile manually)

---

## 🚀 Steps

### 1. Clone the repo

```bash
git clone https://github.com/your-username/SimpleExpenseTracker.git
cd SimpleExpenseTracker
```

### 2. Compile the source

```bash
javac src/**/*.java
```


### 3. Run the application 
```bash
java src/Presentation/Menu.java
```

---

## 💾 Sample Data
The budgets.dat and expenses.dat files store serialized objects for persisting your budgets and expenses between runs.

These files are automatically created after your first save and can be used to test persistence functionality.



