import java.io.Serializable;

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private int companyId;
    private String companyName;
    private String location;
    private String jobRole;

    public Company(int companyId, String companyName,
                   String location, String jobRole) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
        this.jobRole = jobRole;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void displayCompany() {

        System.out.println("\n----- Company Details -----");
        System.out.println("Company ID : " + companyId);
        System.out.println("Company    : " + companyName);
        System.out.println("Location   : " + location);
        System.out.println("Job Role   : " + jobRole);
    }

    @Override
    public String toString() {

        return "ID: " + companyId +
               " | Company: " + companyName +
               " | Location: " + location +
               " | Job Role: " + jobRole;
    }
}