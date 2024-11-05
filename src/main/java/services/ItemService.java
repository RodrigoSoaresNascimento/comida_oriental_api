package services;

import model.Item;

import java.util.List;

public interface ItemService {

    Item adicionarItem(Item item);

    Item editarItem(Item item);

    void removerItem(Integer id);

    List<Item> listarItens();

    Item selecionarItem(Integer id);

}
