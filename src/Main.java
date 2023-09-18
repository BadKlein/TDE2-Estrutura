import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Digite o tamanho das Pilha: ");
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        int jogadas = 0;
        Random n = new Random();


        // Criacao das 3 pilhas do jogo
        Pilha a = new Pilha(tam);
        Pilha b = new Pilha(tam);
        Pilha c = new Pilha(tam);
        // Preenchimento de uma das pilhas com os valores que devem ser ordenados
        a.preenchePilha();

        int opcao;
        do {
            System.out.println("Digite 1 se quiser jogar ou 2 se quiser ver a solucao automatica");
            opcao = sc.nextInt();
        } while (opcao != 1 && opcao != 2);

        do {
            // Finaliza o jogo se por sorte a pilha ja for gerada ordenada
            if (a.verificaOrdenacao()) {
                System.out.println("Pilha ordenada!!!! Jogo encerrado...");
                break;
            }
            // Variavel para salvar o valor que foi removido de uma pilha para que possa ser adicionado em outra posteriormente
            int valor = 0;

            System.out.println("PILHA 1:");
            a.printList();
            System.out.println("PILHA 2:");
            b.printList();
            System.out.println("PILHA 3:");
            c.printList();

            // Variavel que salva o input do usuario onde eh escolhido de qual pilha o valor sera removido e em qual pilha o valor sera adicionado
            int remove, add;
            boolean remocaoFeita = false;


            do {

                if (opcao == 1) {
                    System.out.println("Selecione de qual pilha deseja remover:");
                    remove = sc.nextInt();
                } else {
                    remove = n.nextInt(1, 4);
                }

                if (remove == 1 && a.getTopo() != -1) {
                    valor = a.pop();
                    remocaoFeita = true;
                } else if (remove == 2 && b.getTopo() != -1) {
                    valor = b.pop();
                    remocaoFeita = true;
                } else if (remove == 3 && c.getTopo() != -1) {
                    valor = c.pop();
                    remocaoFeita = true;
                } else {
                    System.out.println("Valor invalido!");
                }
            } while ((remove != 1 && remove != 2 && remove != 3) || remocaoFeita == false);


            boolean aux = false;
            do {
                if (opcao == 1) {
                    do {
                        System.out.println("Selecione em qual pilha deseja adicionar o valor removido: ");
                        add = sc.nextInt();
                    } while (add == remove);
                } else {
                    add = n.nextInt(1, 4);

                }
                if (add == remove) {
                    if (remove == 1) {
                        aux = a.voltaJogada(valor);
                    } else if (remove == 2) {
                        aux = b.voltaJogada(valor);

                    } else if (remove == 3) {
                        aux = c.voltaJogada(valor);
                    }
                } else if (add == 1) {
                    aux = a.push(valor);
                } else if (add == 2) {
                    aux = b.push(valor);
                } else if (add == 3) {
                    aux = c.push(valor);
                } else {
                    System.out.println("Valor invalido!");
                }


            } while ((add != 1 && add != 2 && add != 3) || aux == false);

            if (!aux) {
                if (remove == 1) {
                    a.push(valor);
                } else if (remove == 2) {
                    b.push(valor);
                } else {
                    c.push(valor);
                }
                jogadas--;
            }


            System.out.println("PILHA 1:");
            a.printList();
            System.out.println("PILHA 2:");
            b.printList();
            System.out.println("PILHA 3:");
            c.printList();

            System.out.println("\n \n");
            jogadas++;

        } while (!a.verificaOrdenacao() && !b.verificaOrdenacao() && !c.verificaOrdenacao());


        System.out.printf("Ordenação concluída em %d jogadas! ", jogadas);
    }
}