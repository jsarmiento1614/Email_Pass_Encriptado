/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author Alumno
 */
public class Menu {
    public void header(){
       System.out.println("********************************************************************************************"); 
       System.out.println("*\033[34m                                    INGRESO DE USUARIOS©                                   *");    
       System.out.println("*******************************                             ********************************");
        
    }
    public void headerIniciarSesion(){
       System.out.println("\t**************");
       System.out.println("\t\033[34mINICIAR SESIÓN");    
       System.out.println("\t**************");    
   }
    public void headerRegistro(){
       System.out.println("\t**************");
       System.out.println("\t\033[34mCREAR TU CUENTA");    
       System.out.println("\t**************");   
   }
}
