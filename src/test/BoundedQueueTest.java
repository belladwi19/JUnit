package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.BoundedQueue;

public class BoundedQueueTest {

    private BoundedQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new BoundedQueue(5); // for example, capacity is set to 5
    }

    @Test
    public void testConstructorNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedQueue(-1),
                "Constructor should throw exception for negative capacity");
    }

    @Test
    public void testConstructorZeroCapacity() {
        BoundedQueue bQueue = new BoundedQueue(0);
        assertEquals(bQueue.isFull(), bQueue.isEmpty());
    }

    @Test
    public void testConstructorPositiveCapacity() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testEnQueueNullElement() {
        assertThrows(NullPointerException.class, () -> queue.enQueue(null),
                "EnQueue should throw exception for null element");
    }

    @Test
    public void testEnQueueFullQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        assertThrows(IllegalStateException.class, () -> queue.enQueue(6),
                "EnQueue should throw exception for full queue");
    }

    @Test
    public void testEnQueueForNullQueue() {
        BoundedQueue bQueue = null;
        assertThrows(NullPointerException.class, () -> bQueue.enQueue(6),
                "EnQueue should throw exception for null queue");
    }

    @Test
    public void testEnQueueSingleElement() {
        queue.enQueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testEnQueueElementsDifferentDataTypes() {
        queue.enQueue(1);
        queue.enQueue("");
        queue.enQueue(new int[]{});
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDeQueueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.deQueue(),
                "DeQueue should throw exception for empty queue");
    }

    @Test
    public void testDeQueueNullQueue() {
        BoundedQueue bQueue = null;
        assertThrows(NullPointerException.class, () -> bQueue.deQueue(),
                "DeQueue should throw exception for null queue");
    }

    @Test
    public void testDeQueue() {
        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(1, queue.deQueue(), "DeQueue should return the first element enQueued");
        assertEquals(2, queue.deQueue(), "DeQueue should return the next first element enQueued");
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyNullQueue() {
        BoundedQueue bQueue = null;
        assertThrows(NullPointerException.class, () -> bQueue.isEmpty(),
                "isEmpty should throw exception for null queue");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        queue.enQueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enQueue operation");
    }

    @Test
    public void testIsFullNullQueue() {
        BoundedQueue bQueue = null;
        assertThrows(NullPointerException.class, () -> bQueue.isFull(),
                "isFull should throw exception for null queue");
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull(), "Queue should not be full initially");
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        assertTrue(queue.isFull(), "Queue should be full after enQueueing capacity number of elements");
    }

    @Test
    public void testToString() {
        assertEquals("[]", queue.toString(), "Empty queue should return empty brackets");
        queue.enQueue(1);
        assertEquals("[1]", queue.toString(), "Queue with one element should return that element");
        queue.enQueue(2);
        assertEquals("[1, 2]", queue.toString(), "Queue with two elements should return those elements in order");
    }
}
