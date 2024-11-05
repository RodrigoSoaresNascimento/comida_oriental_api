package services;

import model.Pedido;

public interface PedidoService {

    Pedido cadastrar(Pedido pedido);

    Double calcularValorPedido(Pedido pedido);

    void removerPedido (Integer id);

    Pedido atualizarPedido (Pedido pedido);

    void listarPedidos ();



}
