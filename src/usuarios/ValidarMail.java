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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidarMail {
    
    public void validar(String email, String password, int sentinela){ 
        
        Usuarios callLogin = new Usuarios();
        Registro callRegistro =new Registro();
        querys callQ= new querys();
        // Patrón para validar el email
        Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
            if (mather.find() == true) {
                callQ.getStatedEmailUsers(email, password, sentinela);
            } else {
                
                System.out.println("____________________________________________________________________________________________"); 
                System.out.println("\n\033[31m-------------------El email ingresado no cumple los requisitos como correo------------------");
                System.out.println("\t\t\t\tDeseas Registrarte Ahora-->'S/N'");
                System.out.println("____________________________________________________________________________________________"); 
                System.out.print(" ");
                callRegistro.questionResgitro();
            }       
    } 
    public void validarRegistro(String email, String password){
        Usuarios callLogin = new Usuarios();
        Registro callregistro =new Registro();
        
        // Patrón para validar el email
        Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
            if (mather.find() == true) {
                querys callQ= new querys();
                callQ.InsertUserNew(email, password);
                System.out.println(".........................");    
            } else {
                System.out.println("____________________________________________________________________________________________"); 
                System.out.println("\n\033[31m-------------------El email ingresado no cumple los requisitos como correo------------------");
                System.out.println("____________________________________________________________________________________________\n\n\n");
                
                callregistro.registroUser();    
                
            }       
    }
}
