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
            if (index == 0) {
                addFirst(e);
                return;
            }
            if (index == size) {
                addLast(e);
                return;
            }
            Node<E> current = getNode(index);
            Node<E> newNode = new Node<>(e);

            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }

        public E removeFirst() {
            if (size == 0) return null;
            Node<E> temp = head;
            head = head.previous;
            if (head != null) {
                head.next = null;
            }
            else {
                tail = null;
            }
            size--;
            return temp.element;
        }

        public E removeLast() {
            if (size == 0) return null;
            Node<E> temp = tail;
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
            else {
                head = null;
            }
            size--;
            return temp.element;
        }

        @Override
        public void remove(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size) {
                removeLast();
                return;
            }
            
            Node<E> current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return current.element;
        }
    }
}
