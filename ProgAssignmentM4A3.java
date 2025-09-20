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
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
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
            head = head.next;
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
        public E remove(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size - 1) {
                removeLast();
                return;
            }
            
            Node<E> current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return current.element;
        }

        private Node<E> getNode(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
            if (index < size / 2) {
                Node<E> current = head;
                for (int i = 0; i < index; i ++) {
                    current = current.next;
                }
                return current;
            }
            else {
                Node<E> current = tail;
                for (int i = size - 1; i > index; i--) current = current.previous;
                return current;
            }
        }

        @Override
        public boolean add(E e) {
            addLast(e);
            return true;
        }


        @Override 
        public E get(int index) {
            return getNode(index).element;
        }

        @Override
        public E set(int index, E e) {
            Node<E> current = getNode(index);
            E old = current.element;
            current.element = e;
            return old;
        }

        @Override
        public int indexOf(Object o) {
            int i = 0;
            for (Node<E> cur = head; cur != null; cur = cur.next, i++) {
                if (Objects.equals(cur.element, o)) return i;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(E e) {
            int i = size - 1;
            for (Node<E> cur = tail; cur != null; cur = cur.previous, i--) {
                if (Objects.equals(cur.element, e)) return i;
            }
            return -1;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                Node<E> current = head;
                public boolean hasNext() { return current != null; }
                public E next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    E e = current.element;
                    current = current.next;
                    return e;
                }
            };
        }

        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public ListIterator<E> listIterator(int index) {
            return new ListIterator<E>() {
                Node<E> current = (index == size) ? null : getNode(index);
                int currentIndex = index;

                public boolean hasNext() { return currentIndex < size; }
                public E next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    E e = current.element;
                    current = current.next;
                    currentIndex++;
                    return e;
                }
                public boolean hasPrevious() { return currentIndex > 0; }
                public E previous() {
                    if (!hasPrevious()) throw new NoSuchElementException();
                    if (current == null) current = tail;
                    else current = current.previous;
                    currentIndex--;
                    return current.element;
                }
                public int nextIndex() { return currentIndex; }
                public int previousIndex() { return currentIndex - 1; }
                public void remove() { throw new UnsupportedOperationException(); }
                public void set(E e) { throw new UnsupportedOperationException(); }
                public void add(E e) { throw new UnsupportedOperationException(); }
            };
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node<E> current = head;
            while (current != null) {
                sb.append(current.element);
                if (current.next != null) sb.append(", ");
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }


    }

    
    public interface MyList<E> extends Collection<E> {
        /** Add a new element at the specified index in this list */
        public void add(int index, E e);

        /** Return the element from this list at the specified index */
        public E get(int index);

        /** Return the index of the first matching element in this list.
         *  Return −1 if no match. */
        public int indexOf(Object e);

        /** Return the index of the last matching element in this list
         *  Return −1 if no match. */
        public int lastIndexOf(E e);

        /** Remove the element at the specified position in this list 
         *  Shift any subsequent elements to the left.
         *  Return the element that was removed from the list. */
        public E remove(int index);

        /** Replace the element at the specified position in this list
         *  with the specified element and returns the new set. */
        public E set(int index, E e);

        @Override /** Add a new element at the end of this list */
        public default boolean add(E e) {
            add(size(), e);
            return true;
        }

        @Override /** Return true if this list contains no elements */
        public default boolean isEmpty() {
            return size() == 0;
        }

        @Override /** Remove the first occurrence of the element e 
        * from this list. Shift any subsequent elements to the left.
        * Return true if the element is removed. */
        public default boolean remove(Object e) {
            if (indexOf(e) >= 0) {
                remove(indexOf(e));
                return true;
            } else {
                return false;
            }
        }

        @Override
        public default boolean containsAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean addAll(Collection<? extends E> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean removeAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean retainAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default Object[] toArray() {
            // Left as an exercise
            return null;
        }

        @Override
        public default <T> T[] toArray(T[] array) {
            // Left as an exercise
            return null;
        }
    }
    
}
