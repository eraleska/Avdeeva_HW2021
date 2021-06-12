
    import java.math.BigInteger;

    public class HashMap {
        // Srtting table size to a max of 32, value used to modulus for hash value.
        private final static int TABLE_SIZE = 32;

        HashEntry[] table;

        HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
        }

        /* function to retrieve value from the table according to key */
        public int get(String key) {
            int hash = new BigInteger(toAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();
            while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
            if (table[hash] == null)
                return -1;
            else
                return table[hash].getValue();
        }

        /* function to add value to the table */
        public void put(String key, int value) {
            //creating hash code using key value given as a string
            int hash = new BigInteger(toAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();
            while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
            table[hash] = new HashEntry(key, value);
        }

        /* value to create the Hash code from he name entered, basically converting name to ASCII */
        public static String toAscii(String s){
            StringBuilder sb = new StringBuilder();
            long asciiInt;
            // loop through all values in the string, including blanks
            for (int i = 0; i < s.length(); i++){
                //getting Ascii value of character and adding it to the string.
                char c = s.charAt(i);
                asciiInt = (int)c;
                sb.append(asciiInt);
            }
            return String.valueOf(sb);
        }
}
