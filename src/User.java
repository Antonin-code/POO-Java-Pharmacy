package src;

public class User{
    private String pseudo;
    private String mdp;
    private int id;
    private String role;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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