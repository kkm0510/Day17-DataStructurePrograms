package unorderedlist;

import node.Node;

public class UnorderedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public UnorderedList() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        size++;
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void addAtHead(T data){
        size++;
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next=head;
        head=node;
    }

    public T removeFromHead(){
        if (head == null) return null;
        T ele=head.data;
        head=head.next;
        size--;
        return ele;
    }

    public boolean search(T data) {
        if (head == null) return false;
        for (Node<T> curr = head; curr != null; curr = curr.next) {
            if (curr.data.equals(data)) return true;
        }
        return false;
    }

    public void remove(T data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = null;
            size--;
            return;
        }
        for (Node<T> curr = head; curr.next != null; curr = curr.next) {
            if (curr.next.data.equals(data)) {
                curr.next=curr.next.next;
            }
        }
        size--;
    }

    @Override
    public String toString() {
        if(head==null) return "null";
        StringBuilder s=new StringBuilder();
        for (Node<T> curr = head; curr != null; curr = curr.next) {
            s.append(curr.data).append(" -> ");
        }
        s.append("null");
        return s.toString();
    }

    public boolean isEmpty(){
        return size==0;
    }
}
