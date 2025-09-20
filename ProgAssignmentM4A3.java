import java.util.*;

public class ProgAssignmentM4A3 {
    public static void main(String[] args) {
        //Main implkementation goes here
    }



    public class TwoWayLinkedList<E> implements MyList<E> {
        private Node<E> head, tail;
        private int size = 0;

        private static class Node<E> {
            E element;
            Node<E> next;
            Node<E> previous;

            Node (E e) {
                element = e;
            }
        }

        public TwoWayLinkedList() {

        }

        public TwoWayLinkedList(E[] objects) {
            for (E obj : objects) {
                add(obj);
            }
        }

        @Override
        public int size() {
            return size;
        }

        public void addFirst(E e) {
            Node<E> newNode = new Node<>(e);
            if (head == null) {
                head = tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            size++;
        }

        public void addLast(E e) {
            Node<E> newNode = new Node<>(e);
            if (tail == null) {
                head = tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            size++;
        }

        @Override
        public void add(int index, E e) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException();
            
        }
    }
}
