package view;

import model.*;
import services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu(Scanner scanner){
        System.out.println("------ Bem vindo a nosso app de comida oriental ------");
        System.out.println("Selecione uma opção a baixo");
        int opcao = 0;
        try{
            System.out.println("Digite 1 para ver nosso menu ou qualquer outra coisa para sair");
            opcao = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Deve ser digitado um numero inteiro");
        }
        Pedido pedido = new Pedido();
        PedidoServiceImpl pedidoService = new PedidoServiceImpl();
        ComprovanteEletronicoServiceImpl comprovanteEletronicoService = new ComprovanteEletronicoServiceImpl(pedidoService);
        switch (opcao){
            case 1:
                try{
                ItemServiceImpl itemService = new ItemServiceImpl();
                itemService.listarItens();
                System.out.println("Selecione uma opção do menu");
                Integer item = scanner.nextInt();
                Item prato = itemService.selecionarItem(item);
                System.out.println("Deseja acrescentar algum comentario nesse pedido?");
                scanner.nextLine();
                String comentario = scanner.nextLine();;
                pedido.setObservacao(comentario);
                pedido.setItems(new ArrayList<>());
                pedido.getItems().add(prato);
                adicionarItensPedido(scanner, pedido, itemService);
                scanner.nextLine();
                pedido.setStatusPedido(StatusPedido.INICIADO);
                pedido.setDataPedido(LocalDate.now());
                System.out.println("Cliente por favor digite seu nome");
                String nome = scanner.nextLine();
                Cliente cliente = new Cliente(nome);
                pedido.setCliente(cliente);
                System.out.println("Digite uma forma de pagamento PIX, dinheiro ou cartão");
                String formaPagamento = scanner.nextLine();
                ComprovanteEletronico comprovanteEletronico = new ComprovanteEletronico();
                validarFormadePagamento(formaPagamento, comprovanteEletronico);
                comprovanteEletronico.setPedido(pedido);
                comprovanteEletronicoService.gerarComprovante(comprovanteEletronico);
                break;
                }catch (InputMismatchException e){
                    System.out.println("Digite uma Entrada valida");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Selecione um item valido do menu");
                }
            default:
                System.out.println("Até logo!");
                break;
        }

    }

    private static void adicionarItensPedido(Scanner scanner, Pedido pedido, ItemServiceImpl itemService) {
        Integer item;
        System.out.println("Deseja adicionar outro item ao seu pedido? Digite S,");
        String flag = scanner.next();
        while (flag.equalsIgnoreCase("S")){
            System.out.println("Digite o numero do item que deseja acrescentar");
            item = scanner.nextInt();
            pedido.getItems().add(itemService.selecionarItem(item));
            System.out.println("Para continuar digite S para sair qualquer outra coisa");
            flag = scanner.next();
        }
    }

    private static void validarFormadePagamento(String formaPagamento, ComprovanteEletronico comprovanteEletronico) {
        if(formaPagamento.equalsIgnoreCase(FormaPagamento.CARTAO.name()) || formaPagamento.equalsIgnoreCase(FormaPagamento.PIX.name()) || formaPagamento.equalsIgnoreCase(FormaPagamento.DINHEIRO.name())){
            comprovanteEletronico.setFormaPagamento(FormaPagamento.valueOf(formaPagamento.toUpperCase()));
        }else{
            System.out.println("Forma de pagamento invalida");
        }
    }

}
