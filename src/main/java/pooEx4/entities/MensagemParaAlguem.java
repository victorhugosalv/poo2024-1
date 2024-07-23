package pooEx4.entities;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonima, String emailDestinatario) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public MensagemParaAlguem(){
        super();
        this.emailDestinatario = "";
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(!ehAnonima())
            return "Mensagem para: " + getEmailDestinatario() + " . Texto: " + getTexto() + "\n";
        else
            return "Mensagem de: " + getEmailRemetente() + " para " + getEmailDestinatario() + " . Texto: " + getTexto() + "\n";
    }
}
