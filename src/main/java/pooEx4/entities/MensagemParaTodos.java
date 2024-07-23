package pooEx4.entities;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    public MensagemParaTodos(){
        super();
    }

    public String getTextoCompletoAExibir(){
        if(!ehAnonima())
            return "Mensagem para todos. Texto: " + getTexto() + "\n";
        else
            return "Mensagem de: " + getEmailRemetente() + " para todos. Texto: " + getTexto() + "\n";
    }
}
