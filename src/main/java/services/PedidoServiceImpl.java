package services;

import model.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoServiceImpl implements PedidoService{

    public List<Pedido> pedidos = new ArrayList<>();

    @Override
    public Pedido cadastrar(Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    @Override
    public Double calcularValorPedido(Pedido pedido) {
        Pedido pedidoCadastrado = pedidos.stream()
                .filter(pedido1 -> pedido1.getId() == pedido.getId()).toList().get(0);


        return pedidoCadastrado.getItems().stream()
                .mapToDouble(value -> value.getPrecoDoItem())
                .sum();
    }

    @Override
    public void removerPedido(Integer id) {
        pedidos.removeIf(pedido -> pedido.getId() == id);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        Pedido pedidoCadastrado = pedidos.stream()
                .filter(pedido1 -> pedido1.getId() == pedido.getId()).toList().get(0);
        if (!pedido.getItems().isEmpty()){
            pedidoCadastrado.setItems(pedido.getItems());
        }
        if (pedido.getObservacao() != null){
            pedidoCadastrado.setObservacao(pedido.getObservacao());
        }
        if(pedido.getStatusPedido() != null){
            pedidoCadastrado.setStatusPedido(pedido.getStatusPedido());
        }
        pedidoCadastrado.setDataPedido(LocalDate.now());
        pedidos.add(pedidoCadastrado);
        return pedidoCadastrado;
    }

    @Override
    public void listarPedidos() {
        pedidos.forEach(System.out::println);
    }
}
