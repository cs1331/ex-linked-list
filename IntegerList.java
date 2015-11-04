import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerList
    implements Collection<Integer> {

    private class ListNode {
        private ListNode next;
        private Integer val;

        private ListNode(Integer val) {
            this.val = val;
            this.next = null;
        }
    }

    private class IntegerListIterator implements Iterator<Integer> {
        private ListNode cursor; // next node returned by next()

        private IntegerListIterator(ListNode head) {
            cursor = head;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            ListNode current = cursor;
            cursor = cursor.next;
            return current.val;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }
    }

    private ListNode head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerListIterator(head);
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return null == head;
    }

    @Override
    public int size() {
        int size = 0;
        for (ListNode cursor = head;
                cursor != null;
                cursor = cursor.next) {
            ++size;
        }
        return size;
    }

    @Override
    public boolean add(Integer val) {
        ListNode cursor = null, prev = null;
        for (cursor = head; cursor != null; cursor = cursor.next) {
            prev = cursor;
        }

        if (null == prev) {
            head = new ListNode(val);
        } else {
            prev.next = new ListNode(val);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListNode cursor = null, prev = null;

        for (cursor = head;
                !cursor.val.equals(o) && cursor != null;
                cursor = cursor.next) {
            prev = cursor;
        }

        if (null != cursor) {
            prev.next = cursor.next;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        ListNode cursor = head;
        while (!cursor.val.equals(o) && cursor != null) {
            cursor = cursor.next;
        }

        return cursor != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains = true;
        for (Object o: c) {
            contains &= this.contains(o);
        }
        return contains;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}
