package model.resources.pojos;

public class UserAppPojo {
    private String username;
    private String password;
    private String email;
    private String role;
    private OfficialPojo officialPojo;
    private OwnerPojo ownerPojo;
    private VetPojo vetPojo;

    public UserAppPojo(){

    }
    public UserAppPojo(String username, String password, String email, String role, OfficialPojo officialPojo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.officialPojo = officialPojo;

    }

    public UserAppPojo(String username, String password, String email, String role, OwnerPojo ownerPojo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.ownerPojo = ownerPojo;
    }

    public UserAppPojo(String username, String password, String email, String role,VetPojo vetPojo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.vetPojo = vetPojo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public OwnerPojo getOwnerPojo() {
        return ownerPojo;
    }
    public void setOwnerPojo(OwnerPojo ownerPojo) {
        this.ownerPojo = ownerPojo;
    }

    public OfficialPojo getOfficialPojo() {
        return officialPojo;
    }

    public void setOfficialPojo(OfficialPojo officialPojo) {
        this.officialPojo = officialPojo;
    }

    public VetPojo getVetPojo() {
        return vetPojo;
    }

    public void setVetPojo(VetPojo vetPojo) {
        this.vetPojo = vetPojo;
    }
}