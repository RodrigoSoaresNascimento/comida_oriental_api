package view;

import model.Cliente;
import services.ClienteServiceImpl;
import services.ItemServiceImpl;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Rodrigo");
        Cliente cliente1 = new Cliente("Teste");

        ClienteServiceImpl clienteService = new ClienteServiceImpl();

        clienteService.cadastrar(cliente);
        clienteService.cadastrar(cliente1);


        clienteService.listarClientes();

        Scanner scanner = new Scanner(System.in);
        menu(scanner);

    }

    public static void menu(Scanner scanner){
        System.out.println("------ Bem vindo a nosso app de comida oriental ------");
        System.out.println("Selecione uma opção a baixo");
        System.out.println("Digite 1 para ver nosso menu ou qualquer outra coisa para sair");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                ItemServiceImpl itemService = new ItemServiceImpl();
                itemService.listarItens();
                System.out.println("Selecione uma opção do menu");
                Integer item = scanner.nextInt();
                itemService.selecionarItem(item);
                break;
            default:
                System.out.println("Até logo!");
                break;
        }

    }

}
