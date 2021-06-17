public class HashTable {
        int[] arr;
        int capacity;
        public HashTable(int capacity) {
                this.capacity = next(capacity);
                arr = new int[this.capacity];
        }

        private static boolean isPrime(int n) {
                if (n == 2 || n == 3) {
                        return true;
                }
                if (n == 1 || n % 2 == 0) {
                        return false;
                }
                for (int i = 3; i * i <= n; i += 2) {
                        if (n % i == 0)
                                return false;
                }
                return true;
        }
        private static int next(int n) {
                if (n % 2 == 0) {
                        n++;
                }
                for (; !isPrime(n); n += 2);

                return n;
        }

        public void insert(int elem) {
                arr[elem % capacity] = elem;
        }

        public boolean search(int ele) {
                return arr[ele % capacity] == ele;
        }

        public void delete(int ele) {
                if (arr[ele % capacity] == ele) {
                        arr[ele % capacity] = 0;
                }
                else {
                        System.out.println("Element is not found");
                }
        }

        public boolean get(int key) {
                int index = key % capacity;
                return arr[index] == key;
        }
}
