package pooEx3.program;

import pooEx3.models.SistemaAmigo;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();

        Scanner input = new Scanner(System.in);

        System.out.println("Quantidade de pessoas que vai brincar?");
        int quantAmigos = input.nextInt();
        input.nextLine();

        String[] emails = new String[quantAmigos];

        for(int k = 0; k < quantAmigos; k++){
            System.out.println("Qual o nome? ");
            String nome = input.nextLine();

            System.out.println("Qual o email? ");
            String email = input.nextLine();

            emails[k] = email;

            sistema.cadastraAmigo(nome, email);

            if(k >= 1){
                sistema.configuraAmigoSecretoDe(sistema.pesquisaAmigo(emails[k]).getEmail(), sistema.pesquisaAmigo(emails[k-1]).getEmail());
            }

        }

        sistema.configuraAmigoSecretoDe(sistema.pesquisaAmigo(emails[0]).getEmail(), sistema.pesquisaAmigo(emails[1]).getEmail());

        for(int i = 0; i < quantAmigos; i++){
            String nomeTemp = sistema.pesquisaAmigo(emails[i]).getNome();
            System.out.println("O amigo secreto de " + nomeTemp + " é: "
                    + sistema.pesquisaAmigoSecretoDe(sistema.pesquisaAmigo(emails[i]).getEmail()));
        }

        System.out.println("Escreva o Texto: ");
        String texto = input.nextLine();

        System.out.println("Qual o email: ");
        String emailE = input.nextLine();

        System.out.println("Deseja que seja anonima(Sim/Nao)? ");
        String test = input.nextLine();

        if(test.equalsIgnoreCase("SIM")){
            sistema.enviarMensagemParaTodos(texto,emailE,true);
        }
        if(test.equalsIgnoreCase("NAO")){
            sistema.enviarMensagemParaTodos(texto,emailE,false);
        }
    }
}