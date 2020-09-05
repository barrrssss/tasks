import java.util.*;
import java.util.function.UnaryOperator;

public class ListToQueueAdapter<E> implements Queue<E> {
    private List<E> list;

    public ListToQueueAdapter(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        try {
            E element = list.get(0);
            list.remove(0);
            return element;
        } catch (IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public E poll() {
        try {
            E element = list.get(0);
            list.remove(0);
            return element;
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public E element() {
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public E peek() {
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void replaceAll(UnaryOperator<E> operator) {
        list.replaceAll(operator);
    }

    @Override
    public void clear() {
        list.clear();
    }
}