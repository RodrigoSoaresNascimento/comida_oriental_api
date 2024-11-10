package model;

public class ComprovanteEletronico {

    private Integer id;

    private Pedido pedido;

    private FormaPagamento formaPagamento;

    public ComprovanteEletronico(Pedido pedido, FormaPagamento formaPagamento) {
        this.pedido = pedido;
        this.formaPagamento = formaPagamento;
    }

    public ComprovanteEletronico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "------------- ComprovanteEletronico -------------" + "\n"+
                pedido + "\n"+
                "formaPagamento : " + formaPagamento;
    }
}
