package pooEx3.entities;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private final boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public Mensagem(){
        this("","",false);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetete) {
        this.emailRemetente = emailRemetete;
    }

    public boolean ehAnonima() {
        return anonima;
    }

}
