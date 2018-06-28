package list.test;

import list.RecursiveLinkedList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/** 
* RecursiveLinkedList Tester. 
* 
* @author Dan Blaga
* @since <pre>Jun 21, 2018</pre> 
* @version 1.0 
*/ 
public class RecursiveLinkedListTest {

    private RecursiveLinkedList<String> linkedList;

    @Before
    public void before() {

        linkedList = new RecursiveLinkedList<>("111");
        linkedList.addNode("112");
        linkedList.addNode("113");
        linkedList.addNode("114");

    }

    @After
    public void after() {
        linkedList = null;
    }

    /**
    *
    * Method: addHead(T data)
    *
    */
    @Test
    public void addHeadTest() {
        linkedList.addHead("121");
        assertEquals("121", linkedList.getData());
        assertEquals(5, linkedList.getListSize());
        assertEquals("121 111 112 113 114 ", linkedList.toString());
        linkedList.addHead("122");
        assertEquals("122", linkedList.getData());
        assertEquals(6, linkedList.getListSize());
        assertEquals("122 121 111 112 113 114 ", linkedList.toString());
    }

    /**
    *
    * Method: addNode(T data)
    *
    */
    @Test
    public void addNodeTest() {
        linkedList.addNode("115");
        assertEquals(5, linkedList.getListSize());
        assertEquals("111 112 113 114 115 ", linkedList.toString());
        linkedList.addNode("116");
        assertEquals(6, linkedList.getListSize());
        assertEquals("111 112 113 114 115 116 ", linkedList.toString());
    }

    /**
    *
    * Method: toString()
    *
    */
    @Test
    public void toStringTest() {
        assertEquals("111 112 113 114 ", linkedList.toString());
    }

    /**
    *
    * Method: getListSize()
    *
    */
    @Test
    public void getListSizeTest() {
        assertEquals(4, linkedList.getListSize());
        linkedList.addHead("116");
        assertEquals(5, linkedList.getListSize());
        linkedList.addNode("121");
        assertEquals(6, linkedList.getListSize());
        linkedList.addAt(2, "131");
        assertEquals(7, linkedList.getListSize());
    }

    /**
    *
    * Method: getNodeAtIndex(int index)
    *
    */
    @Test
    public void getNodeAtFirstIndexTest() {
        RecursiveLinkedList<String> head = linkedList.getNodeAtIndex(0);
        assertEquals(linkedList.getData(), head.getData());
    }

    /**
     *
     * Method: getNodeAtIndex(int index)
     *
     */
    @Test
    public void getNodeAtMiddleIndexTest() {
        RecursiveLinkedList<String> node = linkedList.getNodeAtIndex(2);
        assertEquals("113", node.getData());
    }

    /**
     *
     * Method: getNodeAtIndex(int index)
     *
     */
    @Test
    public void getNodeAtLastIndexTest() {
        RecursiveLinkedList<String> node = linkedList.getNodeAtIndex(3);
        assertEquals("114", node.getData());
    }

    /**
     *
     * Method: getNodeAtIndex(int index)
     *
     */
    @Test(expected = NoSuchElementException.class)
    public void getNodeAtNegativeIndexExceptionTest() {
        linkedList.getNodeAtIndex(-1);
    }

    /**
     *
     * Method: getNodeAtIndex(int index)
     *
     */
    @Test(expected = NoSuchElementException.class)
    public void getNodeAtLargeIndexTestExceptionTest() {
        linkedList.getNodeAtIndex(Integer.MAX_VALUE);
    }

    /**
    *
    * Method: getIndexOfNode(T node)
    *
    */
    @Test
    public void getIndexOfNodeTest() {
        linkedList.addNode("131");
        linkedList.addNode("132");
        linkedList.addNode("133");
        assertEquals(2, linkedList.getIndexOfNode("113"));
        assertEquals(4, linkedList.getIndexOfNode("131"));
    }

    /**
     *
     * Method: getIndexOfNode(T node)
     *
     */
    @Test(expected = NoSuchElementException.class)
    public void getIndexOfNodeExceptionTest() {
        linkedList.getIndexOfNode("115");
    }

    /**
    *
    * Method: removeNode(T node)
    *
    */
    @Test
    public void removeFirstNodeTest() {
        linkedList.removeNode("111");
        assertEquals("112", linkedList.getData());
    }

    /**
     *
     * Method: removeNode(T node)
     *
     */
    @Test
    public void removeMiddleNodeTest() {
        linkedList.removeNode("113");
        assertFalse(linkedList.contains("113"));
    }

    /**
     *
     * Method: removeNode(T node)
     *
     */
    @Test
    public void removeLastNodeTest() {
        linkedList.removeNode("114");
        assertFalse(linkedList.contains("114"));
    }

    /**
     *
     * Method: removeNode(T node)
     *
     */
    @Test(expected = NoSuchElementException.class)
    public void removeNodeExceptionTest() {
        linkedList.removeNode("115");
    }

    /**
    *
    * Method: addAt(int index, T data)
    *
    */
    @Test
    public void addAtFirstIndexTest() {
        linkedList.addAt(0, "110");
        assertEquals("110", linkedList.getData());
    }

    /**
     *
     * Method: addAt(int index, T data)
     *
     */
    @Test
    public void addAtMiddleIndexTest() {
        linkedList.addAt(2, "110");
        assertTrue(linkedList.contains("110"));
    }

    /**
     *
     * Method: addAt(int index, T data)
     *
     */
    @Test
    public void addAtLastIndexTest() {
        linkedList.addAt(linkedList.getListSize() - 1, "110");
        assertTrue(linkedList.contains("110"));
    }

    /**
     *
     * Method: addAt(int index, T data)
     *
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtNegativeIndexExceptionTest() {
        linkedList.addAt(-1, "110");
    }

    /**
     *
     * Method: addAt(int index, T data)
     *
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtLargeIndexExceptionTest() {
        linkedList.addAt(Integer.MAX_VALUE, "110");
    }

    /**
    *
    * Method: removeAt(int index)
    *
    */
    @Test
    public void removeAtFirstIndexTest() {
        linkedList.removeAt(0);
        assertEquals("112", linkedList.getData());
    }

    /**
     *
     * Method: removeAt(int index)
     *
     */
    @Test
    public void removeAtMiddleIndexTest() {
        linkedList.removeAt(2);
        assertFalse(linkedList.contains("113"));
    }

    /**
     *
     * Method: removeAt(int index)
     *
     */
    @Test
    public void removeAtLastIndexTest() {
        linkedList.removeAt(linkedList.getListSize() - 1);
        assertFalse(linkedList.contains("114"));
    }

    /**
     *
     * Method: removeAt(int index)
     *
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtNegativeIndexTest() {
        linkedList.removeAt(-1);
    }

    /**
     *
     * Method: removeAt(int index)
     *
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtLargeIndexTest() {
        linkedList.removeAt(Integer.MAX_VALUE);
    }

    /**
    *
    * Method: reverse()
    *
    */
    @Test
    public void reverseTest() {
        linkedList = linkedList.reverse();
        assertEquals("114 113 112 111 ", linkedList.toString());
        linkedList = linkedList.reverse();
        assertEquals("111 112 113 114 ", linkedList.toString());
        linkedList.addNode("121");
        linkedList.addNode("122");
        linkedList = linkedList.reverse();
        assertEquals("122 121 114 113 112 111 ", linkedList.toString());
    }

} 
