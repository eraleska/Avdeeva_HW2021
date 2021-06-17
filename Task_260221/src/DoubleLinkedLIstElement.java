  public class DoubleLinkedLIstElement {

        public static void main(String args[])
        {
            DoubleLinkedList myLinkedlist = new DoubleLinkedList();
            myLinkedlist.insertFirst(5);
            myLinkedlist.insertFirst(6);
            myLinkedlist.insertFirst(7);
            myLinkedlist.insertFirst(1);
            myLinkedlist.insertLast(2);
            myLinkedlist.printLinkedListForward();
            myLinkedlist.printLinkedListBackward();

            System.out.println("================");
            // 1 ->  7 -> 6 -> 5 -> 2
            Node node=new Node();
            node.data=1;
            myLinkedlist.deleteAfter(node);
            myLinkedlist.printLinkedListForward();
            myLinkedlist.printLinkedListBackward();
            // 2 -> 1 -> 6 -> 5
            System.out.println("================");
            myLinkedlist.deleteFirst();
            myLinkedlist.deleteLast();
            //  6 -> 5
            myLinkedlist.printLinkedListForward();
            myLinkedlist.printLinkedListBackward();
        }
    }

