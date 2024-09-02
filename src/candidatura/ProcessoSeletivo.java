package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        /*analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);*/
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com Sucesso");
        }while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "º tentativa");
        }else {
            System.out.println("Não conseguimos contato com " + candidato + " após " + tentativasRealizadas + " " +
                    "tentativas realizadas");
        }
    }

    // método auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase==salarioPretendido) {
            System.out.println("Fazer contraproposta");
        }else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo"};

        System.out.println("Imprimindo a lista de candidatos com índica");
        for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");
        for(String candidato : candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
                "Daniela", "José", "Pedro"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + "Solicitou o salário de: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + "foi selecionado");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
