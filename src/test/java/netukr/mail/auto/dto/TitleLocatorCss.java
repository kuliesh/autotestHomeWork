package netukr.mail.auto.dto;

public class TitleLocatorCss {
    private String titleOpenSession;
    private String titleSecurityLog;
    private String titlePasswordChange;
    private String titleRecoveryContacts;
    private String titlePersonalInfo;
    private String titleAppPasswords;
    private String titleAccountDeletion;

    public String getTitleOpenSession() {
        return titleOpenSession;
    }
    public void setTitleOpenSession(String titleOpenSession) {
        this.titleOpenSession = titleOpenSession;
    }
    public String getTitleSecurityLog() {
        return titleSecurityLog;
    }
    public void setTitleSecurityLog(String titleSecurityLog) {
        this.titleSecurityLog = titleSecurityLog;
    }
    public String getTitlePasswordChange() {
        return titlePasswordChange;
    }
    public void setTitlePasswordChange(String titlePasswordChange) {
        this.titlePasswordChange = titlePasswordChange;
    }
    public String getTitleRecoveryContacts() {
        return titleRecoveryContacts;
    }
    public void setTitleRecoveryContacts(String titleRecoveryContacts) {
        this.titleRecoveryContacts = titleRecoveryContacts;
    }
    public String getTitlePersonalInfo() {
        return titlePersonalInfo;
    }
    public void setTitlePersonalInfo(String titlePersonalInfo) {
        this.titlePersonalInfo = titlePersonalInfo;
    }
    public String getTitleAppPasswords() {
        return titleAppPasswords;
    }
    public void setTitleAppPasswords(String titleAppPasswords) {
        this.titleAppPasswords = titleAppPasswords;
    }
    public String getTitleAccountDeletion() {
        return titleAccountDeletion;
    }
    public void setTitleAccountDeletion(String titleAccountDeletion) {
        this.titleAccountDeletion = titleAccountDeletion;
    }

    @Override
    public String toString() {
        return "TitleLocator{" +
                "titleOpenSession='" + titleOpenSession + '\'' +
                ", titleSecurityLog='" + titleSecurityLog + '\'' +
                ", titlePasswordChange='" + titlePasswordChange + '\'' +
                ", titleRecoveryContacts='" + titleRecoveryContacts + '\'' +
                ", titlePersonalInfo='" + titlePersonalInfo + '\'' +
                ", titleAppPasswords='" + titleAppPasswords + '\'' +
                ", titleAccountDeletion='" + titleAccountDeletion + '\'' +
                '}';
    }
}
