package services;

import model.ComprovanteEletronico;

public class ComprovanteEletronicoServiceImpl implements ComprovanteEletronicoService{

    private final PedidoService pedidoService;

    public ComprovanteEletronicoServiceImpl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public void gerarComprovante(ComprovanteEletronico comprovanteEletronico) {
        System.out.println(comprovanteEletronico);
        System.out.println("O valor total do seu pedido é : ");
        System.out.print(pedidoService.calcularValorPedido(comprovanteEletronico.getPedido()));
    }
}
