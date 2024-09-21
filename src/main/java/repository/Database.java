package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // Método para conectar ao banco de dados SQLite
    public static Connection connect() {
        String url = "jdbc:sqlite:sistema_vendas_estoque.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String sqlProduto = "CREATE TABLE IF NOT EXISTS produto (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "preco REAL NOT NULL," +
                "quantidade INTEGER NOT NULL)";

        String sqlVenda = "CREATE TABLE IF NOT EXISTS venda (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "produto_id INTEGER NOT NULL," +
                "quantidade INTEGER NOT NULL," +
                "data TEXT NOT NULL," +
                "FOREIGN KEY (produto_id) REFERENCES produto (id))";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            // Criação das tabelas
            stmt.execute(sqlProduto);
            stmt.execute(sqlVenda);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
