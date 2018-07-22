package compose_method.after;

/**
 * {@link compose_method.before.List}에 비해 각 로직의 의도가 잘 드러내는 메서드 이름을 가짐.
 * {@link List#add(Object)}의 경우 정말 단순한 일을 하는 한 줄에 불가하지만 메서드의 다른 부분과 동등한 수준으로 맞추기 위해
 * 메서드로 추출하는 것이 좋음.
 * <br>
 * <br>
 * Compose Method 의 몇 가지 원칙들<br>
 * 1) 작게 만든다 : 보통 5줄, 가능한 10줄을 넘기지 않는다.<br>
 * 2) 중복 제거 : 사용되지 안헉나 중복된 코드를 제거한다.<br>
 * 3) 의도를 드러낸다 : 변수와 메서드, 파러미터의 이름이 그 목적을 잘 표현하도록 짓는다.<br>
 * 4) 단순화 : 코드를 가능한 한 단순하게 변경한다.<br>
 * 5) 동등한 수준으로 단계를 나눔 : 메서드를 여러 작업 단계로 나눌 때, 각 단계각 동등한 수준이 되도록 함.
 *
 */
public class List {
    public static final int GROWTH_INCREMENT = 10;
    private boolean readOnly;
    private int size;
    private Object[] elements;

    public void add(Object element) {
        if (readOnly) {
            return;
        }

        if (atCapacity()) {
            grow();
        }

        addElement(element);
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private boolean atCapacity() {
        return (size + 1) > elements.length;
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }
}
