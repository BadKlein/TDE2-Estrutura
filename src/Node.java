

public class Node {
    private Integer data;
    private Node next;
    public Node(int novoValor){
        this.data = novoValor;

    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
