package model;

public class Item {

    private static Integer contador = 1;

    private Integer id;

    private String nomeDoItem;

    private Double precoDoItem;

    private String descricao;

    private Integer quantidade;

    public Item(String nomeDoItem, Double precoDoItem, String descricao, Integer quantidade) {
        this.nomeDoItem = nomeDoItem;
        this.precoDoItem = precoDoItem;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.id = contador++;
    }

    public Item() {
    }

    public String getNomeDoItem() {
        return nomeDoItem;
    }

    public void setNomeDoItem(String nomeDoItem) {
        this.nomeDoItem = nomeDoItem;
    }

    public Double getPrecoDoItem() {
        return precoDoItem;
    }

    public void setPrecoDoItem(Double precoDoItem) {
        this.precoDoItem = precoDoItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }



    @Override
    public String toString() {
        return   "-------------------------------------\n"+
                "numero do item" + id + "\n" +
                "nomeDoItem = " + nomeDoItem + "\n" +
                "precoDoItem = " + precoDoItem + "\n" +
                "descricao = " + descricao + "\n" +
                "quantidade = " + quantidade  + "\n" +
                "-------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
