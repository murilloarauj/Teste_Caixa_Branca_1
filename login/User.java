package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User { 
    /*1*/public Connection conectarBD() { 
    /*2*/Connection conn = null;
        /*3*/try { 
        /*4*/Class.forName("com.mysql.Driver.Manager").newInstance(); //Classe está errada 
        /*4*/String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
        /*4*/conn = DriverManager.getConnection(url);
        //catch vazio
        /*5*/} catch (Exception e) { } /*6*/ /*7*/ 
        //conn retornará null se não conectar
        return conn;/*8*/
    }/*9*/

    public String nome = "";
    public boolean result = false;

    
    /*10*/public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        /*11*/Connection conn = conectarBD(); //retorna null se não conectar 

        // INSTRUÇÃO SQL
        sql = "select nome from usuarios ";
        //login e senha tem que ficar direto no SQL
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        /*12*/try { 
            /*13*/Statement st = conn.createStatement();
            /*13*/ResultSet rs = st.executeQuery(sql);
            /*14*/if (rs.next()) {
            /*15*/result = true;
            /*15*/nome = rs.getString("nome");
            }/*16*/
            //catch vazio
        /*17*/} catch (Exception e) { }/*18*/ /*19*/  
        return result;/*20*/
    }/*21*/
}
// fim da class
