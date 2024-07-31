package br.com.prog2.rh.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection getConnection() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";/*Coloque o usuário criado para acesso ao banco*/
        String senha = "pc2";/*Coloque a senha para acesso ao banco*/
        String url = "jdbc:postgresql://127.0.0.1:5432/rh";/*Coloque o
		//servidor onde está instalado o banco*/
        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user,
                    senha);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found.", ex);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return con;
    }
    public static void close(Connection con){
        try{
            con.close();
        }catch(SQLException e){
            System.err.println("Failed to close the connection: " + e.getMessage());
        }
    }
}
