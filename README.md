# oop assignment overview

This repository contains three Java applications designed to demonstrate Object-Oriented Programming (OOP) principles through real-world scenarios in public sector automation. Each system uses Java, encapsulation, inheritance, abstraction, polymorphism, and Scanner-based user input.

---

## 📁 1. AdvancedVehicleTaxManagementSystem

A Java-based system for registering and managing annual tax computation for various vehicle types. It ensures validation, unique registrations, and user interaction through a console menu.

### 🔧 Features

- Abstract class `Vehicle` with:
  - Common attributes: vehicleId, ownerName, yearOfFabrication, registrationNumber, etc.
  - Abstract methods: `calculateTax()`, `generateTaxReport()`
- Concrete classes:
  - `Car`: electric discount, age-based reduction
  - `Truck`: load-capacity and age-based tax adjustment
  - `Motorcycle`: engine capacity impact, depreciation
  - `Bus`: passenger-based increase, age tax
  - `SUV`: 4WD surcharge, aging discount
- Scanner-based UI:
  - Register vehicles (with validation)
  - View all vehicles
  - Calculate and display taxes
  - Generate reports
- Prevents duplicate registration numbers
- Full input validation (future years, capacity checks, electric flag)

---

## 📁 2. advancedtaxenforcementsystem

Simulates a **Rwanda Revenue Authority** (RRA)-style tax enforcement and monitoring platform for PAYE, VAT, and Withholding Tax.

### 🔧 Features

- Abstract class `TaxDeclaration`:
  - Fields like declarationId, taxpayerTIN, amount, date
  - Abstract methods: `calculateTax()`, `validateDeclaration()`, `generateReceipt()`, `enforceCompliance()`
- Concrete classes:
  - `PAYEDeclaration`: salary brackets, late penalties
  - `VATDeclaration`: 18% on sales, declaration validation
  - `WithholdingTaxDeclaration`: services, rent, dividends
- Supporting classes (encapsulation):
  - `Taxpayer`: validates TIN (9 digits), name, type
  - `TaxOfficer`: audits declarations
- Features:
  - Scanner-based tax declaration
  - Generate and print tax receipts
  - Compliance and penalty reporting
  - Declaration list management

---

## 📁 3. vehicleaxmanagement

A fully OOP-driven **Internship Management System** for students from ULK, UR, AUCA, and UK universities.

### 🔧 Features

- Abstract class `Internship`:
  - Internship info: student, company, dates, status
  - Abstract methods: `assignSupervisor()`, `trackProgress()`, `generateReport()`, `validateInternship()`
- Concrete subclasses:
  - `ULKInternship`: 6-week minimum, Master's supervisor
  - `URInternship`: 2–6 months, optional dual supervisors
  - `AUCAInternship`: includes community hours
  - `UKInternship`: requires English certification
  - `RemoteInternship`: allows remote reporting
- Encapsulated supporting classes:
  - `Student`: validates university and email
  - `Supervisor`: qualification & email check
  - `Company`: industry validation
- Scanner-driven interaction for:
  - Creating internships
  - Assigning supervisors
  - Validating internship rules
  - Generating reports

---




