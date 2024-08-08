package pooEx5.exceptions;

public class ClienteNaoExisteException extends RuntimeException{
    public ClienteNaoExisteException(String msg){
        super(msg);
    }
}
