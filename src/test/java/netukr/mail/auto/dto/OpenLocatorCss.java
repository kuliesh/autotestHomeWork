package netukr.mail.auto.dto;

public class OpenLocatorCss {
    private String openOpenSession;
    private String openSecurityLog;
    private String openPasswordChange;
    private String openRecoveryContacts;
    private String openPersonalInfo;
    private String openAppPasswords;
    private String openAccountDeletion;

    public String getOpenOpenSession() {
        return openOpenSession;
    }
    public void setOpenOpenSession(String openOpenSession) {
        this.openOpenSession = openOpenSession;
    }
    public String getOpenSecurityLog() {
        return openSecurityLog;
    }
    public void setOpenSecurityLog(String openSecurityLog) {
        this.openSecurityLog = openSecurityLog;
    }
    public String getOpenPasswordChange() {
        return openPasswordChange;
    }
    public void setOpenPasswordChange(String openPasswordChange) {
        this.openPasswordChange = openPasswordChange;
    }
    public String getOpenRecoveryContacts() {
        return openRecoveryContacts;
    }
    public void setOpenRecoveryContacts(String openRecoveryContacts) {
        this.openRecoveryContacts = openRecoveryContacts;
    }
    public String getOpenPersonalInfo() {
        return openPersonalInfo;
    }
    public void setOpenPersonalInfo(String openPersonalInfo) {
        this.openPersonalInfo = openPersonalInfo;
    }
    public String getOpenAppPasswords() {
        return openAppPasswords;
    }
    public void setOpenAppPasswords(String openAppPasswords) {
        this.openAppPasswords = openAppPasswords;
    }
    public String getOpenAccountDeletion() {
        return openAccountDeletion;
    }
    public void setOpenAccountDeletion(String openAccountDeletion) {
        this.openAccountDeletion = openAccountDeletion;
    }

    @Override
    public String toString() {
        return "OpenLocator{" +
                "openOpenSession='" + openOpenSession + '\'' +
                ", openSecurityLog='" + openSecurityLog + '\'' +
                ", openPasswordChange='" + openPasswordChange + '\'' +
                ", openRecoveryContacts='" + openRecoveryContacts + '\'' +
                ", openPersonalInfo='" + openPersonalInfo + '\'' +
                ", openAppPasswords='" + openAppPasswords + '\'' +
                ", openAccountDeletion='" + openAccountDeletion + '\'' +
                '}';
    }
}
