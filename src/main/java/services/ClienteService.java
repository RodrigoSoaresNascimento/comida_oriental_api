package services;

import model.Cliente;

public interface ClienteService {

    Cliente cadastrar(Cliente cliente);

    void listarClientes ();

    void deletarCliente(Integer id);

    Cliente atualizar(Cliente cliente);


}
