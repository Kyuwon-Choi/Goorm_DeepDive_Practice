import java.util.Iterator;
import java.util.NoSuchElementException;


class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}


class MyQueue<E> implements Iterable<E> {
    private MyLinkedList<E> list;

    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    public void enqueue(E data) {
        list.add(data);
    }

    public E dequeue() {
        if (list.size() == 0) {
            return null;
        }
        E data = list.get(0);
        list.delete(0);
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}


class MyStack<E> implements Iterable<E> {
    private MyLinkedList<E> list;

    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    public void push(E data) {
        list.add(data);
    }

    public E pop() {
        if (list.size() == 0) {
            return null;
        }
        E data = list.get(list.size() - 1);
        list.delete(list.size() - 1);
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}


public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Foo");
        list.add("Bar");
        list.add("Baz");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.delete(2);
        if (list.size() > 2) list.delete(2);

        for (String s : list) {
            System.out.println(s);
        }

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        for (Integer i : queue) {
            System.out.println(i);
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); // null

        for (Integer i : queue) {
            System.out.println(i);
        }

        MyStack<Double> stack = new MyStack<>();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.5);
        stack.push(4.6);
        stack.push(-13.5);

        for (Double d : stack) {
            System.out.println(d);
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1.5);
        stack.push(60.934);

        for (Double d : stack) {
            System.out.println(d);
        }
    }
}
