
import java.util.Iterator;

    public interface IAVLTree<K,V> {
        public V add(K k, V v);

        public V remove(K k, V v) throws Exception;

        public Iterator<V> removeAll(K k);

        public Iterator<V> find(K k);

        public Iterator<V> listAll();

        public int height();
}
