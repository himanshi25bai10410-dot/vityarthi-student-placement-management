# VITyarthi – Student Placement Management System

## 1. Problem Statement

Managing student placement activities manually can be slow and hard to keep organized. Student details, company information, placement opportunities, and application records must be stored correctly so that they can be found and tracked easily.

**VITyarthi** is a Java-based Student Placement Management System. VITyarthi centralizes all placement information into one platform, making it easier to manage, search, and track student placement records.

## 2. Scope of the Project

The scope of VITyarthi includes:

* Managing student records and academic profiles
* Managing recruiting company profiles
* Managing job vacancy drives and placement criteria
* Managing student applications and hiring lifecycle stages
* Providing dynamic search, lookup, and filtering across records
* Real-time dashboard analytics for placement metrics
* Defensive input handling and data sanitization
* Persistent file-based data storage

## 3. Target Users

* **Students** – To browse eligible drives, check cutoffs, and submit applications.
* **Placement Coordinators / Admin** – To oversee student rosters, company drives, review applications, and track overall placement statistics.
* **Recruiting Entities** – Modeled within the system to track openings, job roles, and required skill profiles.

## 4. High-Level Features

* **Student Management** – Register, view rosters, search, and manage candidate profiles.
* **Company Management** – Register hiring partners and manage corporate information.
* **Job & Drive Management** – Create openings, define CGPA cutoffs, and match technical proficiencies.
* **Application Lifecycle Engine** – Process applications through states: `APPLIED` $\rightarrow$ `SHORTLISTED` $\rightarrow$ `SELECTED` $\rightarrow$ `REJECTED`.
* **Automated Eligibility Engine** – Screen students automatically against academic cutoffs and required skill sets.
* **Analytics Dashboard** – Calculate real-time placement conversion and participation percentages.
* **Data Persistence & Recovery** – Serialize application state to binary storage (`placement_data.dat`).
* **Interactive CLI** – 21-point menu-driven console interface with robust input validation.

## 5. Non-Functional Requirements

* **Reliability & Data Integrity:** Uses Java binary object serialization (`placement_data.dat`) to safely save and restore the complete state of entities without data corruption.
* **Defensive Validation & Robustness:** Strict input bounds checking (e.g., numeric ID checks, CGPA range $0.0 \le \text{CGPA} \le 10.0$) preventing invalid runtime states.
* **Usability & Interface:** Interactive, menu-driven CLI offering 21 distinct operations with clear status prompts and error feedback.
* **Performance & Efficiency:** In-memory collection processing using Java `ArrayList` and lambda predicates (`removeIf`) enabling sub-second operations for standard institutional placement batches.
* **Maintainability & Modularity:** Adheres to OOP principles (encapsulation, abstraction, separation of concerns) across distinct domain classes.