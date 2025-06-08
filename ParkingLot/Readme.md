# 🚗 Parking Lot - Low Level Design (LLD)

This project is an extensible, object-oriented Parking Lot management system. It simulates real-world operations such as parking and unparking vehicles, ticket generation, dynamic pricing, and payments with multiple strategies.

---

## 📝 Problem Statement

**Design a Parking Lot system** that supports:
- Multiple vehicle types (e.g., two-wheeler, four-wheeler)
- Multiple parking spots and floors
- Assigning parking spots based on configurable strategies (e.g., nearest entrance/elevator)
- Generating parking tickets
- Calculating parking fees using different pricing strategies
- Accepting payments using multiple payment methods (Card, UPI, etc.)

---

## 🚦 Functional Requirements

- Vehicles enter and exit the parking lot.
- Parking spot allocation is based on configurable strategy (e.g., nearest to entrance).
- Each vehicle is issued a parking ticket upon entry.
- Parking fee is calculated at exit using a chosen pricing strategy.
- Supports different payment methods.
- Handles spot status, vehicle type compatibility, and basic error scenarios.

---

## 🧩 Key Components

| Class/Interface            | Responsibility                                                          |
|----------------------------|--------------------------------------------------------------------------|
| `Vehicle`                  | Represents a vehicle (type, number plate).                              |
| `ParkingSpot` (interface)  | Abstraction for any spot. Implemented by `TwoWheelerParkingSpot`, `FourWheelerParkingSpot`. |
| `ParkingSpotManager`       | Manages spot assignment, availability, and release.                     |
| `SpotAllocationStrategy`   | Interface for allocation logic; implemented by `NearEntranceStrategy`, `NearElevatorStrategy`, etc. |
| `ParkingTicket`            | Represents a parking session (vehicle, spot, times, ID).                |
| `PricingStrategy`          | Interface for dynamic pricing calculation (e.g., hourly, flat rate).     |
| `PaymentStrategy`          | Interface for payment processing (Card, UPI, etc.).                     |
| `Entry` / `Exit`           | Handles vehicle entry and exit workflow.                                 |

---

## 🏛️ Class Diagram

<img width="1061" alt="image" src="https://github.com/user-attachments/assets/57de5528-f3e6-4017-b0c2-1ff8164f166f" />


---


## 🚀 Possible Extensions

- Add support for new vehicle or spot types via enums.
- Implement more advanced pricing or payment strategies.
- Add user input for dynamic simulation.
- Integrate with real-world payment gateways or external systems.

---

## 🏗️ Design Principles Used

- **Strategy Pattern:** For both spot assignment and payment/pricing.
- **Interface Segregation:** For easy extension (allocation, pricing, payment).
- **Single Responsibility:** Each class has a focused role.
- **Open/Closed Principle:** Easy to add new strategies/types without changing core logic.
- **Dependency Injection:** Strategies and managers are injected, not hardcoded.

---
