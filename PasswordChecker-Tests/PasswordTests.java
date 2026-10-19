import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PasswordTests {
    
    @Test
    public void passwordCorrecto() {
        PasswordChecker checker = new PasswordChecker();
        checker.setMinLength(5);
        checker.setCheckDigits(true);
        assertEquals(PasswordChecker.PASSWORD_OK, checker.check("Password123", "Password123"));
    }

    /*
     * CORRECCIÓN DEL TEST:
     * El test original fallaba porque no se establecía la longitud mínima.
     * Al introducir una contraseña corta, el método devolvía ERR_LENGTH (1) antes de comprobar si faltaban los números (ERR_DIGITS - 2).
     * Solución aplicada: Configurar minLength(5) y usar una contraseña de longitud válida ("Password") que solo incumpla la regla de los dígitos.
     */
    @Test
    public void passwordSinNumeros() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckDigits(true);
        checker.setMinLength(5); 
        
        String pass = "Password"; 
        
        assertEquals(PasswordChecker.ERR_DIGITS, checker.check(pass, pass));
    }

    @Test
    public void passwordSinMinusculas() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckLowers(true);
        assertEquals(PasswordChecker.ERR_LOWERS, checker.check("PASSWORD123", "PASSWORD123"));
    }

    @Test
    public void passwordSinMayusculas() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckUppers(true);
        assertEquals(PasswordChecker.ERR_UPPERS, checker.check("password123", "password123"));
    }
}
