public class PasswordTests {
    public void passwordCorrecto() {
        PasswordChecker checker = new PasswordChecker();
        checker.setMinLength(5);
        checker.setCheckDigits(true);
        // Este test PASA
        assert checker.check("Password123", "Password123") == PasswordChecker.PASSWORD_OK;
    }

    public void passwordSinNumeros() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckDigits(true);
        checker.setMinLength(5); 
        // ESTE TEST FALLA: Al no tener números, esperamos ERR_DIGITS (2).
        // Pero como no le hemos configurado para que exija minúsculas/mayúsculas, 
        // y la longitud es correcta, ¿qué pasa? 
        // Si la implementación real tiene otro orden, fallará aquí.
        assert checker.check("Password", "Password") == PasswordChecker.ERR_DIGITS;
    }
}