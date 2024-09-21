package repository;

import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoRepository {

    public void adicionarProduto(String nome, double preco, int quantidade) {
        String sql = "INSERT INTO produto(nome, preco, quantidade) VALUES(?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setDouble(2, preco);
            pstmt.setInt(3, quantidade);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarQuantidade(int produtoId, int quantidadeVendida) {
        String sql = "UPDATE produto SET quantidade = quantidade - ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, quantidadeVendida);
            pstmt.setInt(2, produtoId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
