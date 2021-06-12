
    public class DynamicArrayTest{
        public static void main(String args[]){
            DynamicArray array = new DynamicArray();
            // adding elements at index 0 and 1
            array.addElement(1);
            array.addElement(2);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());

            array.addElement(3);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            // add element at index 1
            array.addElement(1,5);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            // add element at index 2
            array.addElement(2,6);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            array.remove(2);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            array.remove(2);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            array.remove(1);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            array.remove(2);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();
            array.remove(1);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();

            // Trim the array
            array.trimToSize();
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();
            array.addElement(2);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();
            array.addElement(3);
            System.out.println("Size :"+array.size()+
                    " and Capacity :"+array.capacity());
            array.printElements();
        }
    }
