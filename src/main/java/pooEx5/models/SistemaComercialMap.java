package pooEx5.models;

import pooEx5.entities.Cliente;
import pooEx5.entities.Produto;
import pooEx5.exceptions.ClienteNaoExisteException;
import pooEx5.exceptions.NaoExisteClientesComEssePrefixoException;
import pooEx5.exceptions.NaoExisteProdutosDestaCategoriaException;
import pooEx5.exceptions.ProdutoNaoExisteException;

import java.util.*;

public class SistemaComercialMap implements SistemaComercial{

    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public SistemaComercialMap(){
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
    }

    @Override
    public boolean existeProduto(Produto produto){
        if(!produtos.isEmpty()) {
            return produtos.containsKey(produto.getCodigo());
        }
        return false;
    }

    @Override
    public Produto pesquisaProduto(String codigo) throws ProdutoNaoExisteException {
        if(produtos.containsKey(codigo)){
            return produtos.get(codigo);
        }
        throw new ProdutoNaoExisteException("Produto não existe");
    }

    @Override
    public boolean cadastraProduto(Produto produto) {

        if(existeProduto(produto))
            return false;

        produtos.put(produto.getCodigo(), produto);
        return true;
    }

    @Override
    public boolean cadastraCliente(Cliente cliente) {
        if(existeCliente(cliente))
            return false;

        clientes.put(cliente.getId(),cliente);
        return true;
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        if(!clientes.isEmpty()) {
            return clientes.containsKey(cliente.getId());
        }
        return false;
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException{
        Cliente cliente = clientes.get(id);
        if(cliente != null){
            return cliente;
        }
        throw new ClienteNaoExisteException("Não existe esse cliente!");
    }

    @Override
    public Collection<Cliente> pesquisaClientesComNomeComecandoCom(String prefixo) throws NaoExisteClientesComEssePrefixoException {

        List<Cliente> clientesComPrefixo = new ArrayList<>();

        if(!clientes.isEmpty()) {
            for (Cliente cliente : clientes.values()) {
                if (cliente.getNome().startsWith(prefixo))
                    clientesComPrefixo.add(cliente);
            }
            return clientesComPrefixo;
        }

        throw new NaoExisteClientesComEssePrefixoException("Não existem clientes");

    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) throws NaoExisteProdutosDestaCategoriaException {

        List<Produto> produtosDaCategoria = new ArrayList<>();

        if(!produtos.isEmpty()) {
            for(Produto produto: produtos.values()) {
                if(produto.getCategoria().equals(categoria))
                    produtosDaCategoria.add(produto);
            }
            return produtosDaCategoria;
        }

        throw new NaoExisteProdutosDestaCategoriaException("Não existem produtos");
    }
}
