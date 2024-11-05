package services;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteServiceImpl implements ClienteService{

    public List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente cadastrar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void listarClientes() {
        clientes.forEach(System.out::println);
    }

    @Override
    public void deletarCliente(Integer id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {

        Cliente clienteCadastrado = clientes.stream()
                .filter(cliente1 -> cliente1.getId() == cliente.getId()).toList()
                .get(0);
        if (cliente.getNome() != null){
            clienteCadastrado.setNome(cliente.getNome());
        }
        clientes.add(clienteCadastrado);
        return cliente;
    }
}
