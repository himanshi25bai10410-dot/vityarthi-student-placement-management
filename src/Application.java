import java.io.Serializable;

public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    private int applicationId;
    private int studentId;
    private int jobId;
    private String status;

    public Application(int applicationId, int studentId,
                       int jobId, String status) {

        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayApplication() {

        System.out.println("\n----- APPLICATION DETAILS -----");
        System.out.println("Application ID : " + applicationId);
        System.out.println("Student ID     : " + studentId);
        System.out.println("Job ID         : " + jobId);
        System.out.println("Status         : " + status);
    }

    @Override
    public String toString() {

        return "Application ID: " + applicationId +
               " | Student ID: " + studentId +
               " | Job ID: " + jobId +
               " | Status: " + status;
    }
}