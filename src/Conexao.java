package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection GeraConexao() {
        Connection conexao = null;
        try {
            // URL de conexão ao PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/rpg_database";
            String usuario = "postgres";
            String senha = "root";
            // Tentativa de conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar: " + e.getMessage());
            conexao = null;
        }
        return conexao;
    }

    public static void main(String[] args) {
        // Testando a conexão
        Connection conexao = GeraConexao();
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao tentar fechar a conexão: " + e.getMessage());
            }
        }
    }
}

