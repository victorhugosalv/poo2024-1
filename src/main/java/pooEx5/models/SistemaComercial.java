package pooEx5.models;

import pooEx5.entities.Cliente;
import pooEx5.entities.Produto;
import pooEx5.exceptions.ClienteNaoExisteException;
import pooEx5.exceptions.NaoExisteClientesComEssePrefixoException;
import pooEx5.exceptions.NaoExisteProdutosDestaCategoriaException;
import pooEx5.exceptions.ProdutoNaoExisteException;

import java.util.Collection;

public interface SistemaComercial {
    boolean existeProduto(Produto produto);
    Produto pesquisaProduto(String codigo) throws ProdutoNaoExisteException;
    boolean cadastraProduto(Produto produto);
    boolean cadastraCliente(Cliente cliente);
    boolean existeCliente(Cliente cliente);
    Cliente pesquisaCliente(String id) throws ClienteNaoExisteException;
    Collection<Cliente> pesquisaClientesComNomeComecandoCom(String prefixo) throws NaoExisteClientesComEssePrefixoException;
    Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) throws NaoExisteProdutosDestaCategoriaException;
}
