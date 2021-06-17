public class Dequeue {
        // Maximum size of Dequeue
        private static final int MAX_SIZE = 100;
        // Array to implement Dequeue
        private static int dequeue[];
        // Variables to represent front and rear of dequeue
        private static int front = -1;
        private static int rear = -1;
        private static void insertFront(int x) {
            // if array is not full
            if (!isFull()) {
                // case 1 : there are no elements
                // increment front and rear and add element at arr[front]
                if (front == -1) {
                    front = rear = 0;
                    dequeue[front] = x;
                }
                // else, decrement front circularly and add the
                // new element at arr[front]
                else {
                    if (front == 0) {
                        front = MAX_SIZE - 1;
                    } else {
                        front--;
                    }
                    dequeue[front] = x;
                }
            }
        }
        private static void insertRear(int x) {
            // if array is not full
            if (!isFull()) {
                // if this is the first element to be inserted
                // increment front and rear and add element at arr[rear]
                if (rear == -1) {
                    front = rear = 0;
                    dequeue[rear] = x;
                }
                // else increment rear circularly and add
                // new element at arr[rear]
                else {
                    if (rear == MAX_SIZE - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                    dequeue[rear] = x;
                }
            }
        }
        private static void deleteFront() {
            // if array is not empty
            if (!isEmpty()) {
                // if there is only 1 element
                // make front and rear as -1
                if (front == rear) {
                    front = rear = -1;
                }
                // else increment front circularly
                else {
                    if (front == MAX_SIZE - 1) {
                        front = 0;
                    } else {
                        front++;
                    }
                }
            }
        }
        private static void deleteRear() {
            // if array is not empty
            if (!isEmpty()) {
                // if there is only 1 element
                // make front and rear as -1
                if (front == rear) {
                    rear = front = -1;
                }
                // else decrement rear circularly
                else {
                    if (rear == 0) {
                        rear = MAX_SIZE - 1;
                    } else {
                        rear--;
                    }
                }
            }
        }
        private static int getFront() {
            // if array is not empty return arr[front]
            if (!isEmpty()) {
                return dequeue[front];
            }
            return -1;
        }
        private static int getRear() {
            // if array is not empty return arr[rear]
            if (!isEmpty()) {
                return dequeue[rear];
            }
            return -1;
        }
        private static boolean isEmpty() {
            // if front is -1 then deque is empty
            if (front == -1) {
                return true;
            }
            return false;
        }
        private static boolean isFull() {
            // if front is 1 ahead of rear then
            // deque is full
            if ((rear + 1) % MAX_SIZE == front) {
                return true;
            }
            return false;
        }
        public static void main(String[] args) {
            dequeue = new int[MAX_SIZE];
            // Example
            insertFront(5);
            insertRear(10);
            insertRear(11);
            insertFront(19);
            System.out.println(getFront());
            System.out.println(getRear());
            System.out.println(isFull());
            deleteRear();
            System.out.println(getRear());
            deleteFront();
            System.out.println(getFront());
            System.out.println(isEmpty());
        }
    }
