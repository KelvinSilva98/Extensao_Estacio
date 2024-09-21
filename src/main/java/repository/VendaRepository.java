package repository;

import util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaRepository {

    private ProdutoRepository produtoRepo = new ProdutoRepository();

    public void registrarVenda(int produtoId, int quantidade, String data) {
        String sql = "INSERT INTO venda(produto_id, quantidade, data) VALUES(?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, produtoId);
            pstmt.setInt(2, quantidade);
            pstmt.setString(3, data);
            pstmt.executeUpdate();

            // Atualizar a quantidade do produto após registrar a venda
            produtoRepo.atualizarQuantidade(produtoId, quantidade);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
