import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();
    static ArrayList<Job> jobs = new ArrayList<>();
    static ArrayList<Application> applications = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static final String DATA_FILE = "placement_data.dat";

    public static void main(String[] args) {

        loadData();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" STUDENT PLACEMENT MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add Company");
            System.out.println("5. View All Companies");
            System.out.println("6. Search Company by Name");
            System.out.println("7. Add Job");
            System.out.println("8. View All Jobs");
            System.out.println("9. Search Jobs by Role/Skill");
            System.out.println("10. Filter Jobs by CGPA");
            System.out.println("11. Find Eligible Jobs");
            System.out.println("12. Apply for Job");
            System.out.println("13. View All Applications");
            System.out.println("14. View Student Applications");
            System.out.println("15. Filter Applications by Status");
            System.out.println("16. Update Application Status");
            System.out.println("17. Delete Student");
            System.out.println("18. Delete Company");
            System.out.println("19. Delete Job");
            System.out.println("20. Dashboard / Statistics");
            System.out.println("21. Exit");
            System.out.println("=================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    addCompany();
                    break;

                case 5:
                    viewCompanies();
                    break;

                case 6:
                    searchCompanyByName();
                    break;

                case 7:
                    addJob();
                    break;

                case 8:
                    viewJobs();
                    break;

                case 9:
                    searchJobsByRoleOrSkill();
                    break;

                case 10:
                    filterJobsByCgpa();
                    break;

                case 11:
                    findEligibleJobs();
                    break;

                case 12:
                    applyForJob();
                    break;

                case 13:
                    viewApplications();
                    break;

                case 14:
                    viewStudentApplications();
                    break;

                case 15:
                    filterApplicationsByStatus();
                    break;

                case 16:
                    updateApplicationStatus();
                    break;

                case 17:
                    deleteStudent();
                    break;

                case 18:
                    deleteCompany();
                    break;

                case 19:
                    deleteJob();
                    break;

                case 20:
                    showDashboard();
                    break;

                case 21:
                    saveData();

                    System.out.println(
                            "\nData saved successfully!"
                    );

                    System.out.println(
                            "Thank you for using the system!"
                    );

                    sc.close();
                    return;

                default:
                    System.out.println(
                            "\nInvalid choice! Please enter a valid option."
                    );
            }
        }
    }

    // ==========================================
    // INPUT VALIDATION
    // ==========================================

    static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );
            }
        }
    }

    static int readPositiveInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than 0."
            );
        }
    }

    static double readDouble(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );
            }
        }
    }

    static double readCgpa() {

        while (true) {

            double cgpa = readDouble("Enter CGPA: ");

            if (cgpa >= 0 && cgpa <= 10) {
                return cgpa;
            }

            System.out.println(
                    "Invalid CGPA! CGPA must be between 0 and 10."
            );
        }
    }

    static String readNonEmpty(String message) {

        while (true) {

            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }

    // ==========================================
    // SAVE DATA
    // ==========================================

    static void saveData() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(DATA_FILE)
                    );

            out.writeObject(students);
            out.writeObject(companies);
            out.writeObject(jobs);
            out.writeObject(applications);

            out.close();

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data: "
                            + e.getMessage()
            );
        }
    }

    // ==========================================
    // LOAD DATA
    // ==========================================

    @SuppressWarnings("unchecked")
    static void loadData() {

        File file = new File(DATA_FILE);

        if (!file.exists()) {
            return;
        }

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(DATA_FILE)
                    );

            students =
                    (ArrayList<Student>) in.readObject();

            companies =
                    (ArrayList<Company>) in.readObject();

            jobs =
                    (ArrayList<Job>) in.readObject();

            applications =
                    (ArrayList<Application>) in.readObject();

            in.close();

            System.out.println(
                    "\nPrevious data loaded successfully!"
            );

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "Error while loading data: "
                            + e.getMessage()
            );
        }
    }

    // ==========================================
    // ADD STUDENT
    // ==========================================

    static void addStudent() {

        System.out.println("\n----- ADD STUDENT -----");

        int studentId =
                readPositiveInt("Enter Student ID: ");

        for (Student student : students) {

            if (student.getStudentId() == studentId) {

                System.out.println(
                        "\nStudent ID already exists!"
                );

                return;
            }
        }

        String name =
                readNonEmpty("Enter Name: ");

        String branch =
                readNonEmpty("Enter Branch: ");

        double cgpa =
                readCgpa();

        String skills =
                readNonEmpty("Enter Skills: ");

        Student student =
                new Student(
                        studentId,
                        name,
                        branch,
                        cgpa,
                        skills
                );

        students.add(student);

        saveData();

        System.out.println(
                "\nStudent added successfully!"
        );
    }

    // ==========================================
    // VIEW STUDENTS
    // ==========================================

    static void viewStudents() {

        System.out.println("\n----- ALL STUDENTS -----");

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        for (Student student : students) {

            System.out.println(student);
        }
    }

    // ==========================================
    // SEARCH STUDENT
    // ==========================================

    static void searchStudent() {

        System.out.println("\n----- SEARCH STUDENT -----");

        int id =
                readPositiveInt("Enter Student ID: ");

        boolean found = false;

        for (Student student : students) {

            if (student.getStudentId() == id) {

                student.displayStudent();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Student not found."
            );
        }
    }

    // ==========================================
    // DELETE STUDENT
    // ==========================================

    static void deleteStudent() {

        System.out.println("\n----- DELETE STUDENT -----");

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        int studentId =
                readPositiveInt("Enter Student ID to delete: ");

        Student selectedStudent = null;

        for (Student student : students) {

            if (student.getStudentId() == studentId) {

                selectedStudent = student;

                break;
            }
        }

        if (selectedStudent == null) {

            System.out.println(
                    "Student not found."
            );

            return;
        }

        System.out.println(
                "\nStudent found: " + selectedStudent
        );

        System.out.print(
                "Are you sure you want to delete this student? (yes/no): "
        );

        String confirmation =
                sc.nextLine().trim().toLowerCase();

        if (!confirmation.equals("yes")) {

            System.out.println(
                    "Delete operation cancelled."
            );

            return;
        }

        students.remove(selectedStudent);

        applications.removeIf(
                application ->
                        application.getStudentId() == studentId
        );

        saveData();

        System.out.println(
                "\nStudent deleted successfully!"
        );

        System.out.println(
                "Related applications were also removed."
        );
    }

    // ==========================================
    // ADD COMPANY
    // ==========================================

    static void addCompany() {

        System.out.println("\n----- ADD COMPANY -----");

        int companyId =
                readPositiveInt("Enter Company ID: ");

        for (Company company : companies) {

            if (company.getCompanyId() == companyId) {

                System.out.println(
                        "\nCompany ID already exists!"
                );

                return;
            }
        }

        String companyName =
                readNonEmpty("Enter Company Name: ");

        String location =
                readNonEmpty("Enter Location: ");

        String jobRole =
                readNonEmpty("Enter Job Role: ");

        Company company =
                new Company(
                        companyId,
                        companyName,
                        location,
                        jobRole
                );

        companies.add(company);

        saveData();

        System.out.println(
                "\nCompany added successfully!"
        );
    }

    // ==========================================
    // VIEW COMPANIES
    // ==========================================

    static void viewCompanies() {

        System.out.println(
                "\n----- ALL COMPANIES -----"
        );

        if (companies.isEmpty()) {

            System.out.println(
                    "No companies found."
            );

            return;
        }

        for (Company company : companies) {

            System.out.println(company);
        }
    }

    // ==========================================
    // SEARCH COMPANY BY NAME
    // ==========================================

    static void searchCompanyByName() {

        System.out.println(
                "\n----- SEARCH COMPANY BY NAME -----"
        );

        if (companies.isEmpty()) {

            System.out.println(
                    "No companies found."
            );

            return;
        }

        String searchName =
                readNonEmpty("Enter company name to search: ");

        boolean found = false;

        for (Company company : companies) {

            if (company.getCompanyName()
                    .toLowerCase()
                    .contains(searchName.toLowerCase())) {

                System.out.println(company);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "\nNo company found matching: "
                            + searchName
            );
        }
    }

    // ==========================================
    // DELETE COMPANY
    // ==========================================

    static void deleteCompany() {

        System.out.println(
                "\n----- DELETE COMPANY -----"
        );

        if (companies.isEmpty()) {

            System.out.println(
                    "No companies found."
            );

            return;
        }

        int companyId =
                readPositiveInt("Enter Company ID to delete: ");

        Company selectedCompany = null;

        for (Company company : companies) {

            if (company.getCompanyId() == companyId) {

                selectedCompany = company;

                break;
            }
        }

        if (selectedCompany == null) {

            System.out.println(
                    "Company not found."
            );

            return;
        }

        boolean hasJobs = false;

        for (Job job : jobs) {

            if (job.getCompanyId() == companyId) {

                hasJobs = true;

                break;
            }
        }

        if (hasJobs) {

            System.out.println(
                    "\nCannot delete this company!"
            );

            System.out.println(
                    "This company has jobs associated with it."
            );

            System.out.println(
                    "Delete those jobs first."
            );

            return;
        }

        System.out.println(
                "\nCompany found: " + selectedCompany
        );

        System.out.print(
                "Are you sure you want to delete this company? (yes/no): "
        );

        String confirmation =
                sc.nextLine().trim().toLowerCase();

        if (!confirmation.equals("yes")) {

            System.out.println(
                    "Delete operation cancelled."
            );

            return;
        }

        companies.remove(selectedCompany);

        saveData();

        System.out.println(
                "\nCompany deleted successfully!"
        );
    }

    // ==========================================
    // ADD JOB
    // ==========================================

    static void addJob() {

        System.out.println("\n----- ADD JOB -----");

        int jobId =
                readPositiveInt("Enter Job ID: ");

        for (Job job : jobs) {

            if (job.getJobId() == jobId) {

                System.out.println(
                        "\nJob ID already exists!"
                );

                return;
            }
        }

        int companyId =
                readPositiveInt("Enter Company ID: ");

        boolean companyFound = false;

        for (Company company : companies) {

            if (company.getCompanyId() == companyId) {

                companyFound = true;

                break;
            }
        }

        if (!companyFound) {

            System.out.println(
                    "\nCompany ID not found!"
            );

            System.out.println(
                    "Please add the company first."
            );

            return;
        }

        String jobRole =
                readNonEmpty("Enter Job Role: ");

        double minimumCgpa =
                readCgpa();

        String requiredSkill =
                readNonEmpty("Enter Required Skill: ");

        Job job =
                new Job(
                        jobId,
                        companyId,
                        jobRole,
                        minimumCgpa,
                        requiredSkill
                );

        jobs.add(job);

        saveData();

        System.out.println(
                "\nJob added successfully!"
        );
    }

    // ==========================================
    // VIEW JOBS
    // ==========================================

    static void viewJobs() {

        System.out.println("\n----- ALL JOBS -----");

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs found."
            );

            return;
        }

        for (Job job : jobs) {

            System.out.println(job);
        }
    }

    // ==========================================
    // SEARCH JOBS BY ROLE OR SKILL
    // ==========================================

    static void searchJobsByRoleOrSkill() {

        System.out.println(
                "\n----- SEARCH JOBS BY ROLE / SKILL -----"
        );

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs found."
            );

            return;
        }

        String keyword =
                readNonEmpty(
                        "Enter job role or skill to search: "
                );

        boolean found = false;

        for (Job job : jobs) {

            boolean roleMatch =
                    job.getJobRole()
                            .toLowerCase()
                            .contains(keyword.toLowerCase());

            boolean skillMatch =
                    job.getRequiredSkill()
                            .toLowerCase()
                            .contains(keyword.toLowerCase());

            if (roleMatch || skillMatch) {

                System.out.println(job);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "\nNo jobs found matching: "
                            + keyword
            );
        }
    }

    // ==========================================
    // FILTER JOBS BY CGPA
    // ==========================================

    static void filterJobsByCgpa() {

        System.out.println(
                "\n----- FILTER JOBS BY CGPA -----"
        );

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs found."
            );

            return;
        }

        double cgpa =
                readCgpa();

        boolean found = false;

        System.out.println(
                "\nJobs available for CGPA "
                        + cgpa + " or above:"
        );

        for (Job job : jobs) {

            if (cgpa >= job.getMinimumCgpa()) {

                System.out.println(job);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "\nNo jobs found for this CGPA."
            );
        }
    }

    // ==========================================
    // DELETE JOB
    // ==========================================

    static void deleteJob() {

        System.out.println(
                "\n----- DELETE JOB -----"
        );

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs found."
            );

            return;
        }

        int jobId =
                readPositiveInt("Enter Job ID to delete: ");

        Job selectedJob = null;

        for (Job job : jobs) {

            if (job.getJobId() == jobId) {

                selectedJob = job;

                break;
            }
        }

        if (selectedJob == null) {

            System.out.println(
                    "Job not found."
            );

            return;
        }

        System.out.println(
                "\nJob found: " + selectedJob
        );

        System.out.print(
                "Are you sure you want to delete this job? (yes/no): "
        );

        String confirmation =
                sc.nextLine().trim().toLowerCase();

        if (!confirmation.equals("yes")) {

            System.out.println(
                    "Delete operation cancelled."
            );

            return;
        }

        jobs.remove(selectedJob);

        applications.removeIf(
                application ->
                        application.getJobId() == jobId
        );

        saveData();

        System.out.println(
                "\nJob deleted successfully!"
        );

        System.out.println(
                "Related applications were also removed."
        );
    }

    // ==========================================
    // FIND ELIGIBLE JOBS
    // ==========================================

    static void findEligibleJobs() {

        System.out.println(
                "\n----- FIND ELIGIBLE JOBS -----"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs available."
            );

            return;
        }

        int studentId =
                readPositiveInt("Enter Student ID: ");

        Student selectedStudent = null;

        for (Student student : students) {

            if (student.getStudentId() == studentId) {

                selectedStudent = student;

                break;
            }
        }

        if (selectedStudent == null) {

            System.out.println(
                    "Student not found."
            );

            return;
        }

        System.out.println(
                "\nChecking eligibility for Student ID: "
                        + studentId
        );

        boolean found = false;

        for (Job job : jobs) {

            if (job.isEligible(selectedStudent)) {

                System.out.println(
                        "\nEligible Job Found!"
                );

                job.displayJob();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "\nNo eligible jobs found for this student."
            );
        }
    }

    // ==========================================
    // APPLY FOR JOB
    // ==========================================

    static void applyForJob() {

        System.out.println(
                "\n----- APPLY FOR JOB -----"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        if (jobs.isEmpty()) {

            System.out.println(
                    "No jobs available."
            );

            return;
        }

        int studentId =
                readPositiveInt("Enter Student ID: ");

        Student selectedStudent = null;

        for (Student student : students) {

            if (student.getStudentId() == studentId) {

                selectedStudent = student;

                break;
            }
        }

        if (selectedStudent == null) {

            System.out.println(
                    "Student not found."
            );

            return;
        }

        int jobId =
                readPositiveInt("Enter Job ID: ");

        Job selectedJob = null;

        for (Job job : jobs) {

            if (job.getJobId() == jobId) {

                selectedJob = job;

                break;
            }
        }

        if (selectedJob == null) {

            System.out.println(
                    "Job not found."
            );

            return;
        }

        // Duplicate application check
        for (Application application : applications) {

            if (application.getStudentId() == studentId
                    && application.getJobId() == jobId) {

                System.out.println(
                        "\nYou have already applied for this job."
                );

                return;
            }
        }

        // Eligibility check
        if (!selectedJob.isEligible(selectedStudent)) {

            System.out.println(
                    "\nStudent is not eligible for this job."
            );

            return;
        }

        int applicationId =
                applications.size() + 1;

        Application application =
                new Application(
                        applicationId,
                        studentId,
                        jobId,
                        "APPLIED"
                );

        applications.add(application);

        saveData();

        System.out.println(
                "\nApplication submitted successfully!"
        );

        System.out.println(
                "Application ID: "
                        + applicationId
        );

        System.out.println(
                "Status: APPLIED"
        );
    }

    // ==========================================
    // VIEW ALL APPLICATIONS
    // ==========================================

    static void viewApplications() {

        System.out.println(
                "\n----- ALL APPLICATIONS -----"
        );

        if (applications.isEmpty()) {

            System.out.println(
                    "No applications found."
            );

            return;
        }

        for (Application application : applications) {

            System.out.println(application);
        }
    }

    // ==========================================
    // VIEW STUDENT APPLICATIONS
    // ==========================================

    static void viewStudentApplications() {

        System.out.println(
                "\n----- STUDENT APPLICATIONS -----"
        );

        if (applications.isEmpty()) {

            System.out.println(
                    "No applications found."
            );

            return;
        }

        int studentId =
                readPositiveInt("Enter Student ID: ");

        boolean found = false;

        for (Application application : applications) {

            if (application.getStudentId() == studentId) {

                System.out.println(application);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No applications found for this student."
            );
        }
    }

    // ==========================================
    // FILTER APPLICATIONS BY STATUS
    // ==========================================

    static void filterApplicationsByStatus() {

        System.out.println(
                "\n----- FILTER APPLICATIONS BY STATUS -----"
        );

        if (applications.isEmpty()) {

            System.out.println(
                    "No applications found."
            );

            return;
        }

        System.out.println("\nSelect Status:");
        System.out.println("1. APPLIED");
        System.out.println("2. SHORTLISTED");
        System.out.println("3. SELECTED");
        System.out.println("4. REJECTED");

        int choice =
                readInt("Enter your choice: ");

        String selectedStatus;

        switch (choice) {

            case 1:
                selectedStatus = "APPLIED";
                break;

            case 2:
                selectedStatus = "SHORTLISTED";
                break;

            case 3:
                selectedStatus = "SELECTED";
                break;

            case 4:
                selectedStatus = "REJECTED";
                break;

            default:
                System.out.println(
                        "Invalid status choice."
                );
                return;
        }

        boolean found = false;

        System.out.println(
                "\nApplications with status: "
                        + selectedStatus
        );

        for (Application application : applications) {

            if (application.getStatus()
                    .equalsIgnoreCase(selectedStatus)) {

                System.out.println(application);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No applications found with this status."
            );
        }
    }

    // ==========================================
    // UPDATE APPLICATION STATUS
    // ==========================================

    static void updateApplicationStatus() {

        System.out.println(
                "\n----- UPDATE APPLICATION STATUS -----"
        );

        if (applications.isEmpty()) {

            System.out.println(
                    "No applications found."
            );

            return;
        }

        int applicationId =
                readPositiveInt("Enter Application ID: ");

        Application selectedApplication = null;

        for (Application application : applications) {

            if (application.getApplicationId()
                    == applicationId) {

                selectedApplication = application;

                break;
            }
        }

        if (selectedApplication == null) {

            System.out.println(
                    "Application not found."
            );

            return;
        }

        System.out.println("\nSelect New Status:");
        System.out.println("1. APPLIED");
        System.out.println("2. SHORTLISTED");
        System.out.println("3. SELECTED");
        System.out.println("4. REJECTED");

        int statusChoice =
                readInt("Enter your choice: ");

        String newStatus;

        switch (statusChoice) {

            case 1:
                newStatus = "APPLIED";
                break;

            case 2:
                newStatus = "SHORTLISTED";
                break;

            case 3:
                newStatus = "SELECTED";
                break;

            case 4:
                newStatus = "REJECTED";
                break;

            default:

                System.out.println(
                        "Invalid status choice."
                );

                return;
        }

        selectedApplication.setStatus(newStatus);

        saveData();

        System.out.println(
                "\nApplication status updated successfully!"
        );

        System.out.println(
                "Application ID: "
                        + applicationId
                        + " | New Status: "
                        + newStatus
        );
    }

    // ==========================================
    // DASHBOARD / STATISTICS
    // ==========================================

    static void showDashboard() {

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "          PLACEMENT DASHBOARD"
        );

        System.out.println(
                "=========================================="
        );

        int totalStudents =
                students.size();

        int totalCompanies =
                companies.size();

        int totalJobs =
                jobs.size();

        int totalApplications =
                applications.size();

        System.out.println(
                "\n----- OVERALL STATISTICS -----"
        );

        System.out.println(
                "Total Students       : "
                        + totalStudents
        );

        System.out.println(
                "Total Companies      : "
                        + totalCompanies
        );

        System.out.println(
                "Total Jobs           : "
                        + totalJobs
        );

        System.out.println(
                "Total Applications   : "
                        + totalApplications
        );

        int appliedCount = 0;
        int shortlistedCount = 0;
        int selectedCount = 0;
        int rejectedCount = 0;

        for (Application application : applications) {

            String status =
                    application.getStatus();

            if (status.equalsIgnoreCase("APPLIED")) {

                appliedCount++;

            } else if (status.equalsIgnoreCase("SHORTLISTED")) {

                shortlistedCount++;

            } else if (status.equalsIgnoreCase("SELECTED")) {

                selectedCount++;

            } else if (status.equalsIgnoreCase("REJECTED")) {

                rejectedCount++;
            }
        }

        System.out.println(
                "\n----- APPLICATION STATUS -----"
        );

        System.out.println(
                "Applied              : "
                        + appliedCount
        );

        System.out.println(
                "Shortlisted          : "
                        + shortlistedCount
        );

        System.out.println(
                "Selected             : "
                        + selectedCount
        );

        System.out.println(
                "Rejected             : "
                        + rejectedCount
        );

        double placementRate = 0.0;

        if (totalApplications > 0) {

            placementRate =
                    ((double) selectedCount
                            / totalApplications) * 100;
        }

        System.out.printf(
                "\nPlacement Rate       : %.2f%%\n",
                placementRate
        );

        int studentsWithApplications = 0;

        for (Student student : students) {

            boolean hasApplication = false;

            for (Application application : applications) {

                if (application.getStudentId()
                        == student.getStudentId()) {

                    hasApplication = true;

                    break;
                }
            }

            if (hasApplication) {

                studentsWithApplications++;
            }
        }

        System.out.println(
                "Students Applied     : "
                        + studentsWithApplications
        );

        int studentsWithoutApplications =
                totalStudents - studentsWithApplications;

        System.out.println(
                "Students Not Applied : "
                        + studentsWithoutApplications
        );

        System.out.println(
                "=========================================="
        );
    }
}