

public class LinkedList {
    protected Node List;


    public LinkedList(){
        this.List = null;
    }

    public Node getList() {
        return List;
    }

    public void setList(Node list) {
        List = list;
    }

    public void add(int newInt){
       Node newNode = new Node(newInt);
        if(List == null)
        {
            List = newNode;
        }
        else
        {
            Node atual = List;
            while (atual.getNext()!= null){
                atual = atual.getNext();
            }
            atual.setNext(newNode);
        }
    }

    public void printList(){
        Node atual = List;
        while (atual != null) {
            System.out.print(atual.getData()+ " -> ");
            atual= atual.getNext();
        }
        System.out.println("Null");
    }

    public void remove(int indice) {
        Node anterior = null;
        if (indice < getSize() && indice > 0) {
            if (indice == 1) {
                Node excluido = List;
                List = List.getNext();
                excluido = null;
            } else {
                int counter = 0;
                while (counter < indice - 1) {
                    if (List.getNext() == null) {
                        System.out.println("nulo");
                    } else {
                        List = List.getNext();
                        counter++;
                    }
                    Node excluido = List.getNext();
                    List.setNext(excluido.getNext());
                    excluido = null;
                }
            }
        }
        else{
            System.out.println("Index out of bounds");
        }
    }


    public int getSize()
    {
        Node atual = List;
        int counter = 0;
        while (atual != null){
            atual = atual.getNext();
            counter++;
        }
        return counter;
    }





}


