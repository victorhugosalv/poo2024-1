package pooEx4.program;

import pooEx4.entities.Amigo;
import pooEx4.entities.MensagemParaAlguem;
import pooEx4.entities.MensagemParaTodos;
import pooEx4.models.SistemaAmigoMap;

public class TestaSistemaAmigo {

    public static void main(String[] args) {

        SistemaAmigoMap sistema = new SistemaAmigoMap();


        sistema.cadastraAmigo("Jose", "jose@hotmail.com");
        sistema.cadastraAmigo("Maria", "maria@hotmail.com");

        Amigo jose = sistema.pesquisaAmigo("jose@hotmail.com");
        Amigo maria = sistema.pesquisaAmigo("maria@hotmail.com");

        sistema.configuraAmigoSecretoDe(jose.getEmail(),maria.getEmail());

        sistema.configuraAmigoSecretoDe(jose.getEmail(), maria.getEmail());
        sistema.configuraAmigoSecretoDe(maria.getEmail(), jose.getEmail());

        sistema.enviarMensagemParaAlguem("Oi",maria.getEmail(),true, jose.getEmail());
        sistema.enviarMensagemParaTodos("Ola Mundo", maria.getEmail(), true);

        sistema.pesquisaMensagensAnonimas().stream().forEach(mensagem -> {
            if (mensagem instanceof MensagemParaAlguem) {
                System.out.println(((MensagemParaAlguem) mensagem).getTextoCompletoAExibir());
            } else if (mensagem instanceof MensagemParaTodos) {
                System.out.println(((MensagemParaTodos) mensagem).getTextoCompletoAExibir());
            }
        });

        System.out.println(sistema.pesquisaAmigoSecretoDe(jose.getEmail()));
    }
}
