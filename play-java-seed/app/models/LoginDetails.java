package models;

public class LoginDetails {
    private String name;
    private String password;

    public LoginDetails() {
        // Default constructor required for form binding
    }

    public LoginDetails(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

