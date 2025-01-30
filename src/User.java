package src;

public class User{
    private String role;

    public User(String role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return "ADMIN".equals(this.role);
    }

    public boolean isEmployee() {
        return "EMPLOYEE".equals(this.role);
    }
    public boolean Medecin() {
        return "MEDECIN".equals(this.role);
    }
    public boolean ExpertMedecin() {
        return "MEDECIN+".equals(this.role);
    }
}