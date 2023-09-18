
import java.util.Random;
public class Pilha extends LinkedList {
    int topo;
    int tam;

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Pilha(int tam) {
        List = null;
        this.tam = tam;
        topo = -1;
    }


    // metodo que preenche uma das pilhas com os valores a serem ordenados
    public void preenchePilha(){
            Random n = new Random();
        for ( topo = -1; topo < tam-1; topo++) {
          this.add(n.nextInt(1,101));
        }
    }

public boolean voltaJogada(int x){
    this.add(x);
    topo++;
    return true;
}
    public boolean push(int x){
        // verifica se a pilha nao esta cheia
        if (topo < tam - 1){
            Node atual = List;
            // verifica se pilha nao esta vazia (caso esteja nao preciso verificar se a jogada quebra as regras)
            if(topo!= -1) {
                // achamos o valor do topo da lista
                for (int i = 0; i < topo; i++) {
                    atual = atual.getNext();
                }
                // vemos se ele eh maior ou igual o valor que desejamos inserir
                if(atual.getData() >= x) {
                    this.add(x);
                    topo++;
                    return true;
                    // caso nao seja maior ou igual, a jogada quebraria as regras, entao ela nao eh efetuada
                }else{
                    System.out.println("JOGADA INVALIDA!!");
                    return false;
                }
                // se a pilha de destino estiver vazia, simplesmente fazemos a insercao
            }else{
            this.add(x);
            topo++;
            return true;
        }
            // caso a pilha esteja cheia, nao eh realizada a insercao
        }else{
            System.out.println("Pilha cheia, nao eh possivel adicionar valor");
            return false;
        }
    }

    public int pop(){
        int removido = 0;
        // verifica se pilha nao esta vazia
        if(topo != -1) {
            int counter = 0;
            Node atual = List;
            while (counter < topo + 1) {
                //   caso a pilha so tenha um elemento
                if (counter == 0 && atual.getNext() == null) {
                    removido = atual.getData();
                    List = null;
                    topo = -1;
                    break;
                } else if (atual.getNext().getNext() == null) {
                    removido = atual.getNext().getData();
                    System.out.println("removido:" + atual.getNext().getData());
                    atual.setNext(null);
                    topo--;
                    break;
                } else {
                    atual = atual.getNext();
                    counter++;
                }
            }
            return removido;
        }
        return removido;
    }


    public boolean verificaOrdenacao(){
        Node aux = List;
        if(topo == tam -1) {
            for (int i = 0; i < topo; i++) {
                if (aux.getData() < aux.getNext().getData()) {
                    return false;
                }else{
                    aux = aux.getNext();
                }
            }

            return true;
        }
        return false;
    }

    @Override
    public void printList() {
        if(topo> -1) {
            Node atual = List;
            while (atual != null) {
                System.out.print(atual.getData() + " ");
                atual = atual.getNext();
            }
            System.out.println();
        }else{
            System.out.println("pilha vazia");
        }
    }


}