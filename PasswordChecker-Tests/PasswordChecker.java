public class PasswordChecker {
    public static final int PASSWORD_OK = 0;
    public static final int ERR_LENGTH = 1;
    public static final int ERR_DIGITS = 2;
    public static final int ERR_UPPERS = 3;
    public static final int ERR_LOWERS = 4;
    public static final int ERR_BLANK = 5;
    public static final int ERR_NO_MATCH = 6;

    private int minLength = 0;
    private int maxLength = 100;
    private boolean checkDigits = false;
    private boolean checkUppers = false;
    private boolean checkLowers = false;

    public void setMinLength(int minLength) { this.minLength = minLength; }
    public void setMaxLength(int maxLength) { this.maxLength = maxLength; }
    public void setCheckDigits(boolean checkDigits) { this.checkDigits = checkDigits; }
    public void setCheckUppers(boolean checkUppers) { this.checkUppers = checkUppers; }
    public void setCheckLowers(boolean checkLowers) { this.checkLowers = checkLowers; }

    public int check(String password, String repeatPassword) {
        if (password == null || password.isEmpty()) return ERR_BLANK;
        if (password.length() < minLength || password.length() > maxLength) return ERR_LENGTH;
        if (checkDigits && !password.matches(".*\\d.*")) return ERR_DIGITS;
        if (checkLowers && !password.matches(".*[a-z].*")) return ERR_LOWERS;
        if (checkUppers && !password.matches(".*[A-Z].*")) return ERR_UPPERS;
        if (!password.equals(repeatPassword)) return ERR_NO_MATCH;
        return PASSWORD_OK;
    }
}