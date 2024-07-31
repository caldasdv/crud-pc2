package br.com.prog2.rh.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    /**
     * Obtém uma conexão com o banco de dados PostgreSQL.
     *
     * @return uma conexão com o banco de dados ou null se ocorrer um erro
     */
    public static Connection getConnection() {
        // Configurações de conexão com o banco de dados
        String driver = "org.postgresql.Driver"; // Driver JDBC para PostgreSQL
        String user = "postgres";                // Usuário para acessar o banco de dados
        String senha = "pc2";                    // Senha para acessar o banco de dados
        String url = "jdbc:postgresql://127.0.0.1:5432/rh"; // URL de conexão com o banco de dados

        Connection con = null; // Inicializa a conexão como null

        try {
            // Carrega o driver JDBC
            Class.forName(driver);
            // Estabelece a conexão com o banco de dados usando a URL, usuário e senha fornecidos
            con = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            // Lança uma exceção se o driver JDBC não for encontrado
            throw new RuntimeException("Driver JDBC do PostgreSQL não encontrado.", ex);
        } catch (SQLException e) {
            // Imprime uma mensagem de erro se a conexão falhar
            System.err.println("Falha na conexão: " + e.getMessage());
        }

        // Retorna a conexão ou null se houve um erro
        return con;
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @param con a conexão a ser fechada
     */
    public static void close(Connection con) {
        try {
            // Fecha a conexão com o banco de dados
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            // Imprime uma mensagem de erro se a falha ao fechar a conexão
            System.err.println("Falha ao fechar a conexão: " + e.getMessage());
        }
    }
}
