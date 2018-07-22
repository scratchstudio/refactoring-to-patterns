package compose_method.before;

/**
 * 메서드 내부 로직이 한 눈에 이해하기 어려움.
 */
public class List {
    private boolean readOnly;
    private int size;
    private Object[] elements;

    public void add(Object element) {
        if (!readOnly) {
            int newSize = size + 1;

            if (newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
            elements[size++] = element;
        }
    }
}
