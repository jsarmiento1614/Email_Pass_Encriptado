/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;
import java.io.Console;
import java.util.Scanner;
/**
 *
 * @author JSarmiento
 */
public class Usuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        Menu callMenu = new Menu();
        Login callLogin =new Login();
        callMenu.header();
        callLogin.LoginUsers(0);   
    }
    
    public void passwordExample() {        
      Console c = System.console();
      if (c == null) {
          System.err.println("No hay consola.");
          System.exit(1);
      }
        c.printf("Ingrese su contraenia%n");
        String username = c.readLine("Username: ");
        char[] password = c.readPassword("Password: ");
        c.printf("Password cifrada era: %s%n", new String(password));
    }
}
