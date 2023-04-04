public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> append(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
        return newNode;
    }

    public Node<T> insert(int location, T data) {
        if (location < 0 || location > size) {
            throw new IllegalArgumentException("Invalid location");
        }
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (location == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (location == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.getNext();
            }
            Node<T> nextNode = current.getNext();
            newNode.setPrev(current);
            newNode.setNext(nextNode);
            current.setNext(newNode);
            nextNode.setPrev(newNode);
        }
        size++;
        return newNode;
    }

    public Node<T> delete(int location) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        if (location < 0 || location >= size) {
            throw new IllegalArgumentException("Invalid location");
        }
        Node<T> nodeToDelete;
        if (size == 1) {
            nodeToDelete = head;
            head = null;
            tail = null;
        } else if (location == 0) {
            nodeToDelete = head;
            head = head.getNext();
            head.setPrev(null);
        } else if (location == size - 1) {
            nodeToDelete = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            Node<T> current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.getNext();
            }
            nodeToDelete = current.getNext();
            Node<T> nextNode = nodeToDelete.getNext();
            current.setNext(nextNode);
            nextNode.setPrev(current);
        }
        size--;
        return nodeToDelete;
    }

    public int getIndex(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        sb.append("NULL");
        return sb.toString();
    }

    public Node<T> shuffle() {
        Random rand = new Random();
        DoublyLinkedList<T> newList = new DoublyLinkedList<>();
        while (!isEmpty()) {
            int index = rand.nextInt(size);
            Node<T> nodeToDelete = delete(index);
            newList.append(nodeToDelete.getData());
        }
        head = newList.getHead();
        tail = newList.getTail();
        size = newList.getSize();
        return head;
    }

    public DoublyLinkedList<T> partition(T data) {
        DoublyLinkedList<T> newList = new DoublyLinkedList<>();
        Node<T> current = head;
        while (current != null) {
            Node<T> nextNode = current.getNext();
            if (current.getData().compareTo(data) >= 0) {
                delete(getIndex(current.getData()));
                newList.append(current.getData());
            }
            current = nextNode;
        }
        return newList;
    }
}
