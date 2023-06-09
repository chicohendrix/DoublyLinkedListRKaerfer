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

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteOutOfBounds() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.delete(0);
    }

    @Test
    public void testGetIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("one");
        list.append("two");
        list.append("three");
        assertEquals(1, list.getIndex("two"));
        assertEquals(-1, list.getIndex("four"));
    }

    @Test
    public void testToString() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("one");
        list.append("two");
        list.append("three");
        assertEquals("one -> two -> three -> NULL", list.toString());
    }


    @Test
    public void testShuffle() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("one");
        list.append("two");
        list.append("three");
        list.append("four");
        list.append("five");
        list.append("six");
        Node<String> shuffledHead = list.shuffle();
        assertEquals(6, list.getSize());
        assertNotEquals("one -> two -> three -> four -> five -> six -> NULL", list.toString());
    }

    @Test
    public void testPartition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        DoublyLinkedList<Integer> newList = list.partition(3);
        assertEquals(2, list.getSize());
        assertEquals(2, newList.getSize());
        assertEquals("1 -> 2 -> NULL", list.toString());
        assertEquals("3 -> 4 -> NULL", newList.toString());
    }

    @Test
    public void testAlbum() {
        Album album1 = new Album(1, "Artist 1", "Album 1", 10);
        Album album2 = new Album(2, "Artist 2, Artist 3", "Album 2", 5);
        Album album3 = new Album(3, "Artist 4, Artist 5", "Album 3", 8);
        DoublyLinkedList<Album> list = new DoublyLinkedList<>();
        Node<Album> node1 = list.append(album1);
        Node<Album> node2 = list.append(album2);
        Node<Album> node3 = list.append(album3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getSize());
        assertEquals("1: 10 -- [Artist 1] -> 2: 5 -- [Artist 2, Artist 3] -> 3: 8 -- [Artist 4, Artist 5] -> NULL", list.toString());
    }
}
