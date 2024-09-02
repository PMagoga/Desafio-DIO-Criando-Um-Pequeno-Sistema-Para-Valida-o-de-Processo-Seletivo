package DesafioControleFluxo;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in); // instanciado a classe Scanner

        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            // chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        }catch (ParametroInvalidosException exception) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    static void contar(int parametroUm, int parametroDois ) throws ParametroInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        int contagem;
        if (parametroUm < parametroDois) {
            contagem = parametroDois - parametroUm;
        } else throw new ParametroInvalidosException();
        //realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++){
            System.out.println("Imprimindo o núméro " + i);
        }
    }

}
