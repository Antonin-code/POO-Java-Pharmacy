package src;

public class User{
    protected String pseudo;
    protected String mdp;
    protected String role;

    public User(String pseudo, String mdp,  String role) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.role = role;
    }

    public User() {

    }

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