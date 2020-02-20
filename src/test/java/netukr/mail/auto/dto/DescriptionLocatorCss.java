package netukr.mail.auto.dto;

public class DescriptionLocatorCss {
    private String descriptionOpenSession;
    private String descriptionSecurityLog;
    private String descriptionPasswordChange;
    private String descriptionRecoveryContacts;
    private String descriptionPersonalInfo;
    private String descriptionAppPasswords;
    private String descriptionAccountDeletion;

    public String getDescriptionOpenSession() {
        return descriptionOpenSession;
    }
    public void setDescriptionOpenSession(String descriptionOpenSession) {
        this.descriptionOpenSession = descriptionOpenSession;
    }
    public String getDescriptionSecurityLog() {
        return descriptionSecurityLog;
    }
    public void setDescriptionSecurityLog(String descriptionSecurityLog) {
        this.descriptionSecurityLog = descriptionSecurityLog;
    }
    public String getDescriptionPasswordChange() {
        return descriptionPasswordChange;
    }
    public void setDescriptionPasswordChange(String descriptionPasswordChange) {
        this.descriptionPasswordChange = descriptionPasswordChange;
    }
    public String getDescriptionRecoveryContacts() {
        return descriptionRecoveryContacts;
    }
    public void setDescriptionRecoveryContacts(String descriptionRecoveryContacts) {
        this.descriptionRecoveryContacts = descriptionRecoveryContacts;
    }
    public String getDescriptionPersonalInfo() {
        return descriptionPersonalInfo;
    }
    public void setDescriptionPersonalInfo(String descriptionPersonalInfo) {
        this.descriptionPersonalInfo = descriptionPersonalInfo;
    }
    public String getDescriptionAppPasswords() {
        return descriptionAppPasswords;
    }
    public void setDescriptionAppPasswords(String descriptionAppPasswords) {
        this.descriptionAppPasswords = descriptionAppPasswords;
    }
    public String getDescriptionAccountDeletion() {
        return descriptionAccountDeletion;
    }
    public void setDescriptionAccountDeletion(String descriptionAccountDeletion) {
        this.descriptionAccountDeletion = descriptionAccountDeletion;
    }

    @Override
    public String toString() {
        return "DescriptionLocator{" +
                "descriptionOpenSession='" + descriptionOpenSession + '\'' +
                ", descriptionSecurityLog='" + descriptionSecurityLog + '\'' +
                ", descriptionPasswordChange='" + descriptionPasswordChange + '\'' +
                ", descriptionRecoveryContacts='" + descriptionRecoveryContacts + '\'' +
                ", descriptionPersonalInfo='" + descriptionPersonalInfo + '\'' +
                ", descriptionAppPasswords='" + descriptionAppPasswords + '\'' +
                ", descriptionAccountDeletion='" + descriptionAccountDeletion + '\'' +
                '}';
    }
}
