package pooEx5.entities;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private String email;

    public Cliente(String nome, String endereco, String email){
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente(){
        this("","","");
    }

    public abstract String getId();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "CLIENTE: " + nome + "\n"
                + "ENDEREÇO: " + endereco + "\n"
                + "E-MAIL: " + email + "\n";
    }
}
