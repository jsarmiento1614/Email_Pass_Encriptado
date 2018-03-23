/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author JSarmeinto
 */
public class querys {

    int intentos = 0;
    private DataSource ds;
    private Connection conn;

    private Connection connectDB() {
        ds = Datasource.getSQLLiteDataSource();
        conn = null;
        try {
            conn = this.ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void disconnectDB(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getStatedEmailUsers(String email, String password, int sentinela) {
        conn = connectDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from usuarios";
            ps = conn.prepareStatement(query);
            //ps.setString(1, email);
            //ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
                    System.out.println("____________________________________________________________________________________________");
                    System.out.println("\n\033[34m-----------------------------Usuario logueado Satisfactoriamente---------------------------");
                    System.out.println("____________________________________________________________________________________________");
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (conn != null) {
                        disconnectDB(conn);
                    }
                    Perfil callPerfil = new Perfil();
                    callPerfil.wellcome(email);
                    break;
                    //
                }
            }
            //return back;
        } catch (SQLException e) {
            System.out.println("\033[31mHa sucedido un error al insertar la informacion... " + e);
            disconnectDB(conn);
        }
        //Usuario no logueado;
        System.out.println("____________________________________________________________________________________________");
        System.out.println("\n\033[31m-----------------Usted no se encuentra registrado en nuestra Base de Datos------------------");
        System.out.println("____________________________________________________________________________________________");

        sentinela++;
        if (sentinela >= 3) {
            System.out.println("____________________________________________________________________________________________");
            System.out.println("\n\033[31m--------------------   EL ACCESO SE HA RESTRINGIDO POR SEGURIDAD   -------------------");
            System.out.println("\t\t\033[31m    Ha intentado acceder demasiadas veces a su cuenta");
            System.out.println("____________________________________________________________________________________________");
            System.out.println("\t********************************");
            System.out.println("\t\033[34m  EL PROGRAMA A FINALIZADO");
            System.out.println("\t********************************");
            SendMail callSend = new SendMail();
            callSend.enviar(email);
            Login callLogin = new Login();
            callLogin.LoginUsers(0);
            //System.exit(0);
        }
        Login callLogin = new Login();
        callLogin.LoginUsers(sentinela);
    }

    public void InsertUserNew(String email, String password) {
        conn = connectDB();
        PreparedStatement preStmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from usuarios");
            int IdUser = 0;
            while (rs.next()) {
                IdUser = rs.getInt("ID");
            }
            String query = "insert into usuarios(ID,email, password) values (?,?,?) ";
            preStmt = conn.prepareStatement(query);
            IdUser++;
            preStmt.setInt(1, IdUser);
            preStmt.setString(2, email);
            preStmt.setString(3, password);
            preStmt.execute();
            System.out.println("____________________________________________________________________________________________");
            System.out.println("\n\033[34m  ----------------------------Te has registrado Correctamente " + email + "---------------------");
            System.out.println("\t\t\t\033[34mYa puedes INICIAR SESION con tu Correo Electronico");
            System.out.println("____________________________________________________________________________________________");
            Login callLogin = new Login();
            callLogin.LoginUsers(0);
        } catch (SQLException e) {
            System.out.println("\033[31mHa sucedido un error al insertar la informacion...js " + e);
            disconnectDB(conn);
        } finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
