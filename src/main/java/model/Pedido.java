package model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Integer id;

    private Cliente cliente;

    private List<Item> items;

    private String observacao;

    private StatusPedido statusPedido;

    private LocalDate dataPedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente, List<Item> items, String observacao, StatusPedido statusPedido) {
        this.cliente = cliente;
        this.items = items;
        this.observacao = observacao;
        this.statusPedido = statusPedido;
        this.dataPedido = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return  "[---------------------------------]\n"
                +"Pedido  " +
                "cliente : " + cliente + "\n" +
                items +"\n"+
                "observacao : " + observacao + "\n" +
                "statusPedido : " + statusPedido + "\n" +
                "dataPedido : " + dataPedido;
    }
}
