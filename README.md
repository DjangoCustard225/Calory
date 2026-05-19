# Calory 

A lightweight JavaFX desktop app that calculates your **BMR** and **TDEE** based on personal stats, then gives you a daily calorie target based on your goal.

---

## What it does

1. Takes your weight, height, age, gender, and activity level as input
2. Calculates your **Basal Metabolic Rate (BMR)** using the Mifflin-St Jeor equation
3. Multiplies by an activity multiplier to get your **Total Daily Energy Expenditure (TDEE)**
4. Adjusts for your goal — eat at **80% TDEE** to lose weight, **110% TDEE** to gain

---

## Getting Started

### Prerequisites
- Java 11+
- JavaFX SDK

### Run

```bash
javac --module-path /path/to/javafx/lib --add-modules javafx.controls GUI.java
java --module-path /path/to/javafx/lib --add-modules javafx.controls GUI
```

---

## Activity Levels

| Level | Multiplier |
|---|---|
| Sedentary | 1.2 |
| Light | 1.375 |
| Moderate | 1.55 |
| Heavy | 1.725 |
| Athlete | 1.9 |

---

## Tech

- Java + JavaFX
- Mifflin-St Jeor BMR formula
- Single-file, no dependencies beyond JavaFX
