package model;

public class Cliente {

    private static int contador = 1;
    private String nome;

    private Integer id;

    public Cliente(String nome) {
        this.nome = nome;
        this.id = contador++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente " + '\'' +
                "nome = '" + nome + '\'' +
                "id = " + id + '\'';
    }
}
