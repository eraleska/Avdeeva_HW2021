import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NLogNSortTest extends Assertions {
    @Test
    public void sort_emptyArray_doNothing()
    {
        int[] actual = new int[0];
        int[] expected = new int[0];
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort_oneElementArray_doNothing()
    {
        int[] actual = { 10 };
        int[] expected = { 10 };
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort_allElenemtsEquals_doNothing()
    {
        int[] actual = { 10, 10, 10, 10, 10 };
        int[] expected = { 10, 10, 10, 10, 10 };
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort_allElementsDifferent_correctSorting()
    {
        int[] actual = { 10, 1, 5, 11, 2, 6, 8, 4, 9, 3, 7 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort_containsSomeEquals_correctSorting()
    {
        int[] actual = { 10, 1, 5, 5, 11, 2, 5, 6, 8, 1, 4, 2, 10, 9, 3, 7, 10, 1, 2 };
        int[] expected = { 1, 1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10, 11 };
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort_alreadySorted_doNothing()
    {
        int[] actual = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        NLogNSort sort = new NLogNSort();
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
