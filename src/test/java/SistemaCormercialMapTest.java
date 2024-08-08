import org.junit.jupiter.api.Test;
import pooEx5.entities.Cliente;
import pooEx5.entities.ClientePF;
import pooEx5.entities.Produto;
import pooEx5.exceptions.ClienteNaoExisteException;
import pooEx5.exceptions.NaoExisteProdutosDestaCategoriaException;
import pooEx5.exceptions.ProdutoNaoExisteException;
import pooEx5.models.CategoriaProduto;
import pooEx5.models.SistemaComercialMap;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaCormercialMapTest {
    @Test
    public void testaCadastroProdutos(){
        SistemaComercialMap sistema = new SistemaComercialMap();

        assertThrows(NaoExisteProdutosDestaCategoriaException.class, ()-> sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO));

        try {
            Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
            fail("Se falhar não ta lançando a excessao");
        } catch (NaoExisteProdutosDestaCategoriaException e){
            //ok
        }

        Produto prod = new Produto("12345", "Alimento Frio",0.0, 1, CategoriaProduto.ALIMENTO);

        assertThrows(ProdutoNaoExisteException.class, ()-> sistema.pesquisaProduto("1234"));

        try {


            sistema.cadastraProduto(prod);
            assertTrue(sistema.existeProduto(prod));

            Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);

            assertEquals(1, alimentos.size());

            Produto prodTest = sistema.pesquisaProduto("12345");

            assertEquals("12345", prodTest.getCodigo());


        } catch (NaoExisteProdutosDestaCategoriaException | ProdutoNaoExisteException e){
            fail("Não deve falhar pois tem um produto");
        }
    }

    @Test
    public void testaCadastroClientes(){
        SistemaComercialMap sistema = new SistemaComercialMap();

        assertThrows(ClienteNaoExisteException.class, ()-> sistema.pesquisaCliente("123456789-10"));

        try{

            Cliente cliente = new ClientePF("Joel", "Rua bernadinho", "joel@gmail.com", "123456789-10" );
            sistema.cadastraCliente(cliente);
            assertTrue(sistema.existeCliente(cliente));

            Cliente b = sistema.pesquisaCliente("123456789-10");

            assertEquals("Joel", b.getNome());
            assertEquals("Rua bernadinho", b.getEndereco());
            assertEquals("joel@gmail.com",b.getEmail());
            assertEquals("123456789-10", b.getId());


        } catch(ClienteNaoExisteException e){
            fail("Nao deveria dar um erro");
        }

    }
}
