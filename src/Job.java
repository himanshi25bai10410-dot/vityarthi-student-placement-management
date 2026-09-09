import java.io.Serializable;

public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private int jobId;
    private int companyId;
    private String jobRole;
    private double minimumCgpa;
    private String requiredSkill;

    public Job(int jobId, int companyId, String jobRole,
               double minimumCgpa, String requiredSkill) {

        this.jobId = jobId;
        this.companyId = companyId;
        this.jobRole = jobRole;
        this.minimumCgpa = minimumCgpa;
        this.requiredSkill = requiredSkill;
    }

    public int getJobId() {
        return jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public boolean isEligible(Student student) {

        boolean cgpaMatch =
                student.getCgpa() >= minimumCgpa;

        boolean skillMatch =
                student.getSkills()
                       .toLowerCase()
                       .contains(requiredSkill.toLowerCase());

        return cgpaMatch && skillMatch;
    }

    public void displayJob() {

        System.out.println("\n----- Job Details -----");
        System.out.println("Job ID         : " + jobId);
        System.out.println("Company ID     : " + companyId);
        System.out.println("Job Role       : " + jobRole);
        System.out.println("Minimum CGPA   : " + minimumCgpa);
        System.out.println("Required Skill : " + requiredSkill);
    }

    @Override
    public String toString() {

        return "Job ID: " + jobId +
               " | Company ID: " + companyId +
               " | Role: " + jobRole +
               " | Minimum CGPA: " + minimumCgpa +
               " | Required Skill: " + requiredSkill;
    }
}