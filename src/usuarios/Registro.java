/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Registro {
    Scanner teclado=new Scanner(System.in);
    //Instancias de clases
    Login callLogin=new Login();
    ValidarMail callValidator = new ValidarMail(); 
    //instancio el menu
    Usuarios callRegis = new Usuarios(); 
    Menu callMenu = new Menu();
    
    public void registroUser(){ 
        Registro callregistro =new Registro();
        int exit=0;
        
        do{ 
            System.out.println("____________________________________________________________________________________________"); 
            System.out.println("\n\033[34m-----------------New Users, Registrate a Continuacion , ¡Es Gratis!-----------------");
            System.out.println("____________________________________________________________________________________________"); 
            String email="";
            String password="";
            callMenu.headerRegistro(); 
            System.out.println("Ingresa tu Correo:\t\t\t\t\t\t   Ingrese (C) para Cancelar"); 
            System.out.print(" ");
            email=teclado.nextLine();
            callregistro.Exit(email, null);
            
            System.out.println("Ingresa su Contrasenia:");
            System.out.print(" ");
            password=teclado.nextLine();
            callregistro.Exit(null, password);
            callValidator.validarRegistro(email, password);
           // callRegis.dRegistro(); //llamare los datos de registro.
        }while(exit!=1);
       
   }
   public void questionResgitro(){
       String opcion="";
       opcion=teclado.nextLine();
       if("S".equalsIgnoreCase(opcion)){
               Registro callregistro =new Registro();
               callregistro.registroUser();
        }else if("N".equalsIgnoreCase(opcion)){
            
        }else{
            System.out.println("Ha introducido un dato incorrecto...");
        }
   }

   public void Exit(String correo, String password){
       if("C".equalsIgnoreCase(correo) || "C".equalsIgnoreCase(password)){
               System.out.println("____________________________________________________________________________________________");
               System.out.println("\n\033[31m-----------------------------------SUSCRIPCION CANCELADA------------------------------------");
               System.out.println("____________________________________________________________________________________________");
               callLogin.LoginUsers(0);
       }
   }
}
