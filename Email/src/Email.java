import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

     // Constructor to receive first and last name
    public Email(String firstName, String lastName) {
        // this is class level, after `=` is local variable
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Want to call method asking for department...return the department
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // Want to call method that returns a RANDOM password.
        this.password = randomPassword(defaultPasswordLength);
        // System.out.println("Your password is: " + this.password);

        // Combine Elements to Generate Email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        // System.out.println("Your email is: " + this.email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code:");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        in.close();
        return switch(deptChoice) {
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "None";
        };
    }
    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            // Math.random is 0 to 1, passwordSet.length is the length.
            // Cast to int because Math.random returns a double
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    // Set the mailbox capacity - PUBLIC so we can set the capacity.
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    // GET name, email, mailboxCapacity.
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Email \n[firstName= " + firstName + ", lastName= " + lastName + ", password= " + password + ", department= "
                + department + ", email= " + email + ", mailboxCapacity= " + mailboxCapacity +  "mb, alternateEmail= " + alternateEmail + "]";
    }

    // Override toString
    
}
