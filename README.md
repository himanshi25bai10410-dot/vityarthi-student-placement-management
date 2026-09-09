# VITyarthi – Student Placement Management System

[![GitHub Repository](https://img.shields.io/badge/GitHub-Repository-blue?logo=github)](https://github.com/himanshi25bai10410-dot/vityarthi-student-placement-management.git)

## Project Overview

**VITyarthi** is a comprehensive, console-based Java application designed to automate and streamline campus placement activities[cite: 4, 8]. It provides an integrated platform for students, placement cells, and recruiters to manage student profiles, corporate registrations, job drive listings, eligibility evaluations, multi-stage application workflows, and placement analytics[cite: 4, 8]. 

The system demonstrates fundamental and advanced Object-Oriented Programming (OOP) principles, defensive input validation, Java Collections framework operations, and file persistence using Java Object Serialization (`placement_data.dat`)[cite: 8, 9, 10].

---



## Technologies & Tools Used

* **Programming Language:** Java (JDK 8 / 11 / 17 / 21 LTS compatible)
* **Core Concepts:** Object-Oriented Programming (Encapsulation, Data Hiding, Abstraction), Input Sanitization & Bounds Validation
* **Java Collections Framework:** Dynamic listing and in-memory management using `java.util.ArrayList`
* **Data Streams & Persistence:** Binary File I/O via Java Object Serialization (`java.io.ObjectOutputStream`, `java.io.ObjectInputStream`, `Serializable`)
* **Functional Programming:** Lambda Predicates (`java.util.function.Predicate`, `removeIf`) for cascading lifecycle record management
* **Build & Development Tools:** Java Standard Development Kit (`javac`, `java`), Git Version Control
* **Supported IDEs:** Visual Studio Code, IntelliJ IDEA, Eclipse, or Command-Line Terminal


## How to Run

### Prerequisites
* **JDK Version**: JDK 8 or higher (Recommended: JDK 11, 17, or 21)
* **IDE / Tooling**: Any standard terminal, VS Code, IntelliJ IDEA, or Eclipse
* **Hardware Requirements**: Minimum 2GB RAM, 500MB free disk space

### Commands

#### 1. Compile the Project
From the root directory containing the `.java` files:
```bash
javac -d bin *.java
```

#### 2. Run the Main Application
```bash
java -cp bin Main
```

#### 3. Run with Previous Data Persistence
Ensure `placement_data.dat` is located in the execution directory to automatically load saved state on startup:  
```bash
java -cp bin Main
```


### Evolution of Java

1995: Java 1.0 – Initial public release by Sun Microsystems.

1997: Java 1.1 – Inner classes, JavaBeans, RMI, reflection, and JDBC.

1998: Java 1.2 (J2SE) – Introduction of the Collections Framework, Swing GUI, and JIT compiler.

2000: Java 1.3 – HotSpot JVM and Java Naming and Directory Interface (JNDI).

2002: Java 1.4 – Assertions, regular expressions, non-blocking I/O (NIO), and logging API.

2004: Java 5.0 – Generics, annotations, autoboxing/unboxing, enums, varargs, and enhanced for-each loop.

2006: Java 6 – Scripting language support, compiler API, and major performance optimizations.

2011: Java 7 – Try-with-resources, diamond operator (<>), strings in switch, and Fork/Join framework.

2014: Java 8 – Lambda expressions, Stream API, Functional Interfaces, java.time, and default methods.

2017: Java 9 – Java Platform Module System (Project Jigsaw) and JShell REPL.

2018: Java 10–11 (LTS) – Local variable type inference (var), HTTP Client API, and long-term support release.

2019–2020: Java 12–15 – Switch expressions, text blocks, and preview features for records.

2021: Java 17 (LTS) – Sealed classes, Pattern Matching for switch, and finalized Records.

2022–2024: Java 18–21 (LTS) – Virtual Threads (Project Loom), Structured Concurrency, and Scoped Values.

Java Editions Comparison

| Feature | Java ME (Micro Edition) | Java SE (Standard Edition) | Java EE / Jakarta EE (Enterprise Edition) |
|---|---|---|---|
| **Target Platform** | Embedded systems, microcontrollers, IoT devices | Desktop applications, command-line utilities, core backends | Large-scale enterprise web systems and microservices |
| **Memory Footprint** | Extremely small (< 1 MB to a few MBs) | Moderate (30 MB–200 MB) | Heavy (250 MB+ runtime) |
| **Core APIs** | Minimal API subset (CLDC / CDC) | Core Java APIs (`java.lang`, `java.util`, `java.io`) | Full Java SE APIs plus enterprise APIs such as JPA, Servlets, and JMS |
| **UI Support** | LCDUI, MIDP | Swing, JavaFX, AWT, console CLI | Web-based interfaces using JSF, JSP, and REST endpoints |
| **Data Storage** | Record Management System (RMS) | Serialization, file I/O, JDBC | JPA, Hibernate, JTA, and ORM systems |
| **Typical Use Cases** | Smart meters, SIM cards, older feature phones | Standalone utilities, desktop tools, and CLI systems such as VITyarthi | Banking portals, ERP software, and distributed cloud systems |

### JDK / JRE / JVM Architecture
┌────────────────────────────────────────────────────────┐
│                         JDK                            │
│  ┌────────────────────────────────────────────────┐    │
│  │                      JRE                       │    │
│  │  ┌────────────────────────────────────────┐    │    │
│  │  │                  JVM                   │    │    │
│  │  │  - Class Loader Subsystem              │    │    │
│  │  │  - Bytecode Execution Engine (JIT)     │    │    │
│  │  │  - Memory Management & Garbage Collectr│    │    │
│  │  └────────────────────────────────────────┘    │    │
│  │  + Core Class Libraries (java.lang, java.util) │    │
│  │  + Java Object Serialization Engine (java.io)  │    │
│  └────────────────────────────────────────────────┘    │
│  + Development Tools (javac, jar, javadoc, jdb)        │
│  + Header Files & Execution Toolchains                 │
└────────────────────────────────────────────────────────┘

JVM (Java Virtual Machine): Abstract machine that loads and executes compiled .class bytecode, manages heap/stack memory, and performs automatic garbage collection.

JRE (Java Runtime Environment): Provides the execution environment consisting of the JVM, core class libraries, and supporting runtime files.

JDK (Java Development Kit): Complete software development bundle containing the JRE, compiler (javac), archiver (jar), and diagnostics tools required to develop Java applications.

## Installation & Setup Guide

### Windows JDK Setup
1. **Download:** Obtain the latest OpenJDK or Oracle JDK x64 installer.  
2. **Install:** Run the installer wizard and complete the installation (default: `C:\Program Files\Java\jdk-17` or similar).
3. **Set Environment Variables:**
   * Open **System Properties** $\rightarrow$ **Environment Variables**.
   * Under **System Variables**, create `JAVA_HOME` pointing to your installation directory (e.g., `C:\Program Files\Java\jdk-17`).
   * Append `%JAVA_HOME%\bin` to the `Path` variable.
4. **Verify Installation:**
  
  ```bash
   java -version
   javac -version

IDE Setup (VS Code / Eclipse / IntelliJ)

1.Open your chosen IDE and select Open Folder / Import Existing Project[cite: 10].

2.Select the cloned vityarthi-student-placement-management directory.

3.Ensure the project SDK is configured to JDK 8 or above.

4.Run Main.java directly through the IDE interface or internal terminal.

Project Structure & Syllabus Mapping

| Syllabus Topic | File / Class | Method / Concept | Description |
|---|---|---|---|
| **CLI & Entry Point** | `Main.java` | `main(String[] args)` | Implements the console navigation loop and handles user menu selections. |
| **Classes & Encapsulation** | `Student.java` | Private fields, getters, and setters | Encapsulates student credentials, CGPA, branch, and related records. |
| **Object Relationships** | `Job.java`, `Company.java` | `companyId` linking | Establishes the relationship and referential integrity between job openings and companies. |
| **Domain Logic & Eligibility** | `Job.java` | `isEligible(Student student)` | Evaluates eligibility using cutoff criteria and case-insensitive skill matching. |
| **Collections Framework** | `Main.java` | `ArrayList<Student>`, `ArrayList<Job>` | Provides in-memory storage and dynamic listing of domain entities. |
| **Control Flow & Switches** | `Main.java` | `switch (choice)` | Dispatches user requests across 21 console menu actions. |
| **Predicate Filtering** | `Main.java` | `applications.removeIf(...)` | Performs cascading deletion of related application records using lambda predicates. |
| **Defensive Validation** | `Main.java` | `readPositiveInt()`, `readCgpa()` | Sanitizes user input and validates bounds, including \(0.0 \leq \text{CGPA} \leq 10.0\). |
| **Serialization & Persistence** | `Main.java` | `saveData()`, `loadData()` | Stores and restores application data using `ObjectOutputStream` and `ObjectInputStream` binary serialization. |
| **State Machine / Workflow** | `Application.java` | `setStatus(String status)` | Updates the placement candidate lifecycle, such as application status stages. |
| **String Manipulation** | `Job.java`, `Main.java` | `.toLowerCase()`, `.contains()` | Enables case-insensitive, multi-parameter job and skill search functionality. |
| **Aggregation & Analytics** | `Main.java` | `showDashboard()` | Calculates placement percentages and application-funnel statistics in real time. |

### Application Features

    1. Student Management
        Registration: Add students with auto-validated positive numeric IDs, validated CGPA, branch, and technical skill sets.  
        Roster Inspection: Display formatted rosters of all students or perform exact-match lookups using unique Student IDs.  
        Cascading Deletion: Deleting a student systematically purges all associated applications to prevent orphaned records

    2. Company & Recruiter Directory
        Registration: Register recruiting firms with unique Corporate IDs, corporate names, primary locations, and role classifications. 
        Search Operations: Substring search utility matching company names regardless of case formatting.  
        Integrity Guard: Restricts deletion of companies that currently hold active job vacancy postings

    3. Job Drive & Automated Eligibility Engine
        Job Creation: Post openings specifying role titles, assigned company IDs, CGPA cutoff, and required technical proficiencies.  
        Automated Screening: Automated evaluation (Job.isEligible) checking whether a candidate satisfies both the academic cutoff and technical requirements.  Flexible Search: Search job vacancies by specific skills, job titles, or minimum CGPA compatibility.

    4. Application Tracking & Status
         ManagementEnforced Validation: Validates student eligibility prior to application creation and blocks duplicate submissions for the same opening.  
         Status Updates: Update application progress through defined hiring stages: APPLIED $\rightarrow$ SHORTLISTED $\rightarrow$ SELECTED $\rightarrow$ REJECTED.  Targeted Filtering: View applications filtered by specific Student IDs or overall hiring stages.

     5. Placement Dashboard & Analytics
        Overview Aggregates: Displays total counts of registered students, registered companies, active jobs, and total applications.
        Conversion Metrics: Real-time evaluation of total selections against overall applications:$$\text{Placement Rate} = \left(\frac{\text{Selected Applications}}{\text{Total Applications}}\right) \times 100$$
        Engagement Tracking: Tracks overall placement participation rates (students who applied vs. unapplied)

        Usage Guide & Operations
        Interactive Menu Overview
        The system provides a 21-point menu upon launching
        =================================
          STUDENT PLACEMENT MANAGEMENT
        =================================
        1. Add Student                12. Apply for Job
        2. View All Students          13. View All Applications
        3. Search Student             14. View Student Applications
        4. Add Company                15. Filter Applications by Status
        5. View All Companies         16. Update Application Status
        6. Search Company by Name     17. Delete Student
        7. Add Job                    18. Delete Company
        8. View All Jobs              19. Delete Job
        9. Search Jobs by Role/Skill  20. Dashboard / Statistics
        10. Filter Jobs by CGPA       21. Exit
        11. Find Eligible Jobs
        =================================

 ### Quick Workflow Example
    1.Add Company: Select 4 $\rightarrow$ Enter Company ID (1), Name (TCS), Location (Bhopal), Role (Software Engineer)
    2.Add Job: Select 7 $\rightarrow$ Enter Job ID (101), Company ID (1), Role (Software Engineer), Minimum CGPA (7.5), Required Skill (Java).
    3.Add Student: Select 1 $\rightarrow$ Enter Student ID (10410), Name (Himanshi Saxena), Branch (AI/ML), CGPA (8.56), Skills (Java, Python)
    4.Check Eligibility: Select 11 $\rightarrow$ Enter Student ID (10410) $\rightarrow$ System lists matching Job 101. 
    5.Apply for Job: Select 12 $\rightarrow$ Enter Student ID (10410) and Job ID (101) $\rightarrow$ Application submitted with status APPLIED.
    6.Update Status: Select 16 $\rightarrow$ Application ID (1) $\rightarrow$ Update to SELECTED
    7.View Dashboard: Select 20 to verify updated placement rates and funnel breakdowns
    8.Save & Exit: Select 21 to persist all changes to placement_data.dat

## Instructions for Testing

| Test Case ID | Target Feature | Test Action / Input | Expected Result |
|---|---|---|---|
| **TC-01** | Duplicate ID Guard | Register a student with an ID that is already present. | The system rejects the input and displays: `Student ID already exists!` |
| **TC-02** | CGPA Validation Bounds | Enter a CGPA value such as `-1.5` or `12.0`. | The system rejects the value and prompts: `Invalid CGPA! CGPA must be between 0 and 10.` |
| **TC-03** | Company Dependency Guard | Attempt to delete a company ID that has active jobs mapped to it. | The system blocks the deletion and displays: `Cannot delete this company! This company has jobs associated with it.` |
| **TC-04** | Substring Skill Evaluation | Check eligibility for a student with skills `Java Python` for a job requiring `java`. | Job eligibility evaluates to `true` through case-insensitive substring matching. |
| **TC-05** | Duplicate Application Prevention | Apply for the same Job ID with the same Student ID twice. | The system stops the second application and displays: `You have already applied for this job.` |
| **TC-06** | Cascading Purge Integrity | Delete a student who has active job applications. | The student is deleted, and all linked applications are removed using `removeIf(...)`. |
| **TC-07** | Persistence Engine | Add records, select **Option 21**, then rerun the application using `java -cp bin Main`. | The console displays: `Previous data loaded successfully!` and restores all previously saved records. |

 
## Author & Academic Submission Details
* **Project Title:** VITyarthi – Student Placement Management System
* **Author:** Himanshi Saxena
* **Registration ID:** 25BAI10410
* **Repository:** [GitHub Link](https://github.com/himanshi25bai10410-dot/vityarthi-student-placement-management.git)
