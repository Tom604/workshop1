package nl.workshop1.domain;

/**
 *
 * @author FeniksBV
 */
public class Account {

    public static final char ROLE_ADMIN = 'A';
    public static final char ROLE_MEDEWERKER = 'M';
    public static final char ROLE_KLANT = 'K';

    private char role = ' ';
    private String userName = "";
    private String wachtwoord = "";

    public Account() {

    }

    public Account(String userName, String wachtwoord) {
        this.userName = userName;
        this.wachtwoord = wachtwoord;
    }

    /**
     * the role to get
     */
    public char getRole() {
        return role;
    }

    /**
     * the userName to get
     */
    public String getUserName() {
        return userName;
    }

    /**
     * the wachtwoord to get
     */
    public String getWachtwoord() {
        return wachtwoord;
    }
    
    /**
     * @param role the role to set
     */
    public void setRole(char role) {
        this.role = role;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @param wachtwoord the wachtwoord to set
     */
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
    
}
