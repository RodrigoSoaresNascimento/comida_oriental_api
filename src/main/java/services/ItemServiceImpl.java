package services;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemServiceImpl implements ItemService {


    public List<Item> itens = new ArrayList<>(){
        {
            add(new Item("Nigiri de Salmão", 15.00, "Peixe salmão sobre arroz temperado.",  5));
            add(new Item("Hosomaki de Pepino", 12.00, "Alga enrolada com arroz e pepino.",  10));
            add(new Item("Uramaki Califórnia", 18.00, "Arroz por fora, com salmão, pepino e avocado.", 8));
            add(new Item("Yakisoba", 20.00, "Macarrão frito com legumes e carne.",  6));
            add(new Item("Tempurá Misto", 18.00, "Mix de legumes e frutos do mar empanados e fritos.", 4));
            add(new Item("Missô", 10.00, "Sopa de missô com tofu e alga wakame.", 12));
            add(new Item("Ramen", 15.00, "Macarrão japonês em caldo saboroso com carne e ovo.", 8));
            add(new Item("Mochi de Morango", 8.00, "Bolinho de arroz glutinoso recheado com pasta de feijão doce e morango.", 10));
            add(new Item("Tempurá de Banana", 10.00, "Banana empanada e frita.", 5));
        }
    };

    @Override
    public Item adicionarItem(Item item) {
        itens.add(item);
        return item;
    }

    @Override
    public Item editarItem(Item cardapio) {
        Item itemSelecionado = itens.stream().
                filter(item1 -> Objects.equals(cardapio.getId(), item1.getId())).toList().get(0);
        cardapio.setId(itemSelecionado.getId());
        if(cardapio.getNomeDoItem() != null){
            itemSelecionado.setNomeDoItem(cardapio.getNomeDoItem());
        }
        if (cardapio.getPrecoDoItem() != null){
            itemSelecionado.setPrecoDoItem(cardapio.getPrecoDoItem());
        }
        if (cardapio.getDescricao() != null){
            itemSelecionado.setDescricao(cardapio.getDescricao());
        }
        if (cardapio.getQuantidade() != null){
            itemSelecionado.setQuantidade(cardapio.getQuantidade());
        }

        Integer posicaoItem = 0;

        for (Item item : itens){
            posicaoItem++;
            if(item.getId() == itemSelecionado.getId()){
                break;
            }

        }
        itens.add(posicaoItem,itemSelecionado);
        return cardapio;
    }

    @Override
    public void removerItem(Integer id) {
        itens.removeIf(item -> item.getId() == id);
    }

    @Override
    public List<Item> listarItens() {
        itens.forEach(System.out::println);
        return itens;
    }

    @Override
    public Item selecionarItem(Integer id) {
        return itens.get(id-1);
    }
}
