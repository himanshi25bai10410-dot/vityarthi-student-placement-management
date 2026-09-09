import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int studentId;
    private String name;
    private String branch;
    private double cgpa;
    private String skills;

    public Student(int studentId, String name, String branch,
                   double cgpa, String skills) {

        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.skills = skills;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public void displayStudent() {

        System.out.println("\n----- Student Details -----");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Branch     : " + branch);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Skills     : " + skills);
    }

    @Override
    public String toString() {

        return "ID: " + studentId +
               " | Name: " + name +
               " | Branch: " + branch +
               " | CGPA: " + cgpa +
               " | Skills: " + skills;
    }
}