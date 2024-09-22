package model;

public class Venda {
    private int produtoId;
    private int quantidade;
    private String data;

    public Venda(int produtoId, int quantidade, String data) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.data = data;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return data;
    }
}
