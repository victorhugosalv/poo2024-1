package pooEx5.entities;

public class ClientePF extends Cliente{

    private String cpf;

    public ClientePF(String nome, String endereco, String email, String cpf){
        super(nome,endereco,email);
        this.cpf = cpf;
    }

    public ClientePF(){
        this("", "", "","");
    }

    @Override
    public String getId() {
        return cpf;
    }
}
