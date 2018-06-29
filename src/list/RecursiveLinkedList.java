package list;


import java.util.NoSuchElementException;
import java.util.Objects;

public class RecursiveLinkedList<T> {

    private T data;
    private RecursiveLinkedList<T> next = null;

    public RecursiveLinkedList(T data) {
        this.data = data;
    }

    private RecursiveLinkedList<T> getNext() { return this.next; }

    private void setNext(RecursiveLinkedList<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public void addHead(T data) {

        RecursiveLinkedList<T> secondNode = new RecursiveLinkedList<>(this.getData());
        secondNode.setNext(this.getNext());
        this.setData(data);
        this.setNext(secondNode);

    }

    public void addNode(T data) {
        addNode(this, data);
    }

    private void addNode(RecursiveLinkedList<T> currentNode, T data) {

        if (currentNode.getNext() == null) {

            currentNode.setNext(new RecursiveLinkedList<>(data));
            return;

        }

        addNode(currentNode.getNext(), data);

    }

    public String toString() {
        return traverse(this);
    }

    private String traverse(RecursiveLinkedList<T> currentNode) {

        StringBuilder stringBuilder = new StringBuilder(currentNode.getData() + " ");

        if (currentNode.getNext() == null) {
            return stringBuilder.toString();
        }

        stringBuilder.append(traverse(currentNode.getNext()));

        return stringBuilder.toString();

    }

    public int getListSize() {
        return getListSize(this);
    }

    private int getListSize(RecursiveLinkedList<T> currentNode) {

        if (currentNode.getNext() == null) {
            return 1;
        }

        return 1 + getListSize(currentNode.getNext());

    }

    public RecursiveLinkedList<T> getNodeAtIndex(int index) throws NoSuchElementException {

        if (checkIfOutOfBounds(index))
            throw new NoSuchElementException();

        RecursiveLinkedList<T> node = getNodeAtIndex(0, this, index);

        if (null == node)
            throw new NoSuchElementException();

        return node;

    }

    private RecursiveLinkedList<T> getNodeAtIndex(int currentIndex, RecursiveLinkedList<T> currentNode, int index) {

        if (null == currentNode) {
            return null;
        }

        if (currentIndex == index) {
            return currentNode;
        }

        return getNodeAtIndex(currentIndex + 1, currentNode.getNext(), index);

    }

    public int getIndexOfNode(T node) {
        return getIndexOfNode(0, this, node);
    }

    private int getIndexOfNode(int index, RecursiveLinkedList<T> currentNode, T node) throws NoSuchElementException {

        if (currentNode == null)
            throw new NoSuchElementException();

        if (currentNode.getData().equals(node))
            return index;

        return getIndexOfNode(index + 1, currentNode.getNext(), node);

    }

    public void removeNode(T node) {
        removeNode(this, null, node);
    }

    private void removeNode(RecursiveLinkedList<T> currentNode, RecursiveLinkedList<T> previousNode, T node) throws NoSuchElementException {

        if (null == currentNode)
            throw new NoSuchElementException();

        if (currentNode.getData().equals(node)) {

            if (currentNode.getNext() == null) {

                previousNode.setNext(null);
                return;

            }

            shiftListToLeft(currentNode, currentNode.getNext());
            return;

        }

        removeNode(currentNode.getNext(), currentNode, node);

    }

    private void shiftListToLeft(RecursiveLinkedList<T> currentNode, RecursiveLinkedList<T> nextNode) {

        currentNode.setNext(nextNode.getNext());
        currentNode.setData(nextNode.getData());

    }

    public void addAt(int index, T data) throws IndexOutOfBoundsException {

        if (checkIfOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            this.addHead(data);
            return;
        }

        addAt(this, 0, index, data);
    }

    private void addAt(RecursiveLinkedList<T> currentNode, int currentIndex, int index, T data) {

        if (currentIndex == index-1) {

            RecursiveLinkedList<T> node = new RecursiveLinkedList<>(data);
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
            return;

        }

        addAt(currentNode.getNext(), currentIndex + 1, index, data);
    }

    public void removeAt(int index) throws IndexOutOfBoundsException {

        if (checkIfOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        removeAt(this, null, 0, index);

    }

    private void removeAt(RecursiveLinkedList<T> currentNode, RecursiveLinkedList<T> previousNode, int currentIndex, int index) {

        if (currentIndex == index) {

            if (currentNode.getNext() == null) {

                previousNode.setNext(null);
                return;

            }

            shiftListToLeft(currentNode, currentNode.getNext());
            return;

        }

        if (currentNode.getNext() == null) {
            previousNode.setNext(null);
            return;
        }

        removeAt(currentNode.getNext(), currentNode, currentIndex + 1, index);

    }

    private boolean checkIfOutOfBounds(int index) {
        return (index < 0 || index > getListSize() - 1);
    }

    public RecursiveLinkedList<T> reverse() {
        return reverse(null);
    }

    private RecursiveLinkedList<T> reverse(RecursiveLinkedList<T> previous) {

        if (this.getNext() == null) {
            this.setNext(previous);
            return this;
        }

        RecursiveLinkedList<T> retValue = this.getNext().reverse(this);
        this.setNext(previous);
        return retValue;

    }

    public boolean contains(T node) {
        return contains(this, node);
    }

    private boolean contains(RecursiveLinkedList<T> currentNode, T node) {

        if (null == currentNode)
            return false;

        if (currentNode.getData().equals(node)) {
            return true;
        }

        return contains(currentNode.getNext(), node);

    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        RecursiveLinkedList<?> that = (RecursiveLinkedList<?>) o;
        return Objects.equals(getData(), that.getData());

    }

}

