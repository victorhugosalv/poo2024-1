package pooEx5.entities;

public class ClientePJ extends Cliente{

    private String cnpj;

    public ClientePJ(String nome, String endereco, String email, String cnpj) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
    }

    public ClientePJ(){
        this("","","","");
    }


    @Override
    public String getId() {
        return cnpj;
    }
}
