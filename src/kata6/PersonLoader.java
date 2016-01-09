package kata6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonLoader {
    public static ArrayList read() throws ClassNotFoundException, SQLException{
        
        ArrayList <Person1> lista = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection conec = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        Statement state= conec.createStatement();
        ResultSet rs = state.executeQuery( "SELECT * FROM PEOPLE");
        
        while(rs.next()){
            Integer id = rs.getInt(1);
            String name= rs.getString(2);
            String genero = rs.getString(3);
            String FechaDeNacimiento = rs.getString(4);
            float peso = rs.getFloat(5);
            String mail = rs.getString(6);
            lista.add(new Person1(id, name, genero, FechaDeNacimiento, peso, mail));

        }
        return lista;
    }
    
}
