import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void testAppend() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        Node<String> node1 = list.append("one");
        Node<String> node2 = list.append("two");
        Node<String> node3 = list.append("three");
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertOutOfBounds() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insert(1, "one");
    }


    @Test
    public void testDelete() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("one");
        list.append("two");
        Node<String> node3 = list.append("three");
        Node<String> deleted = list.delete(1);
        assertEquals("two", deleted.getData());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

}
