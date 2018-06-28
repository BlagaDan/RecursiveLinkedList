package testing;

import list.RecursiveLinkedList;

public class ClientRecursive {
    public static void main(String args[]) {
        RecursiveLinkedList<String> list = new RecursiveLinkedList<>("bla");
        System.out.println(list.getListSize());

        list.addNode("aaa");
        System.out.println(list.getListSize());

        list.addHead("aba");
        System.out.println(list.toString());

        RecursiveLinkedList<String> element = list.getNodeAtIndex(0);
        System.out.println(element.getData());

        System.out.println();

        list.addAt(2, "test2");
        System.out.println(list.toString());
        System.out.println(list.contains("test1"));

        System.out.println(list.getIndexOfNode("test2"));

        System.out.println();

        list.addNode("1234");
        list.addNode("Node6");
        list.removeAt(5);
        System.out.println(list.toString());

        System.out.println();

        list = list.reverse();
        System.out.println(list.toString());

    }
}
