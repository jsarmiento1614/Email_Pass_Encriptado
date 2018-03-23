/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author jsarmiento
 */
import java.util.Scanner;
public class Perfil {
    public void wellcome(String email){
    Login callLogin = new Login();
    Scanner teclado= new Scanner(System.in);
    String salir="";
    System.out.println("********************************************************************************************"); 
    System.out.println("*\033[34m                               Bienvenido a su Perfil                                   *");    
    System.out.println("*******************************                             ********************************");
    System.out.println("Correo Electronico: " + email);
    System.out.println();
    System.out.println("Cerrar Sesion-> S/N");
    System.out.print(" ");
    salir=teclado.nextLine();
    do {
    if ("S".equalsIgnoreCase(salir)){
        callLogin.LoginUsers(0);
    }else if ("N".equalsIgnoreCase(salir)){
        
    }else{
       System.out.println("Dato incorrecto"); 
    }
    }while(salir.equals("js"));
    
    }
}
