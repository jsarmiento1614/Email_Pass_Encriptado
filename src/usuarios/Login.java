/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author JSarmiento
 */
import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Login {

    public void LoginUsers(int sent) {
        Scanner teclado = new Scanner(System.in);
        String email="";
        String password = "";
        int sentinela = sent;
        //instanciamiento
        Login callLogin = new Login();
        Menu callMenu = new Menu();
        Usuarios callRegis = new Usuarios();
        int exit = 0;
        do {
            callMenu.headerIniciarSesion();
            System.out.println("Ingrese Correo Electrónico:\t\t\t\t\tIngresa(R) para registrarte.");
            System.out.print(" ");
            email = teclado.nextLine();
            callLogin.Cancelar(email, null);
            Console c = System.console();
            if (c == null) {
                System.out.println();
                System.out.println("Ingrese Contraseña:");
                System.out.print(" ");
                password = teclado.nextLine(); 
            }else{
                c.printf(" ");
                char[] pass = c.readPassword("Ingrese Contraseña: ");
                for(int i=0; i<pass.length;i++){
                    password=password + Character.toString(pass[i]);
                }
                //password=Arrays.toString(pass);
                System.out.println(password);
            }
            callLogin.Cancelar(null, password);
            ValidarMail callValidator = new ValidarMail();
            callValidator.validar(email, password, sentinela);
            //callRegis.dRegistro();
        } while (exit != 1);
    }
    
    public void Cancelar(String email, String password) {
        if ("R".equalsIgnoreCase(email) || "R".equalsIgnoreCase(password)) {
            Registro callregistro = new Registro();
            callregistro.registroUser();
        }
    }
}
