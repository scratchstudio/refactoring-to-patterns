package introduce_polymorphic_creation_with_factory_method.after;

import introduce_polymorphic_creation_with_factory_method.common.OutputBuilder;

/**
 * {@link introduce_polymorphic_creation_with_factory_method.before.DOMBuilderTest} 에서 빌더를 생성하는
 * 메서드를 따로 만들고 추상 메서드로 변경 함.
 * 그 실체 구현은 하위 클래스에서 담당함으로써 OutputBuilder 객체를 다형적으로 사용가능해짐.
 * 동일한 메서드들은 모두 상위 클래스로 올려 같이 사용함.
 */
public abstract class AbstractBuilderTest {
    protected OutputBuilder builder;

    protected abstract OutputBuilder createBuilder(String rootName);

    public void testAddAboveRoot() {
        //language=HTML
        String invalidResult =
                "<orders>\n" +
                "    <order>\n" +
                "    </order>\n" +
                "</orders>\n" +
                "<customer>\n" +
                "</customer>";

        builder = createBuilder("orders");
        builder.addBelow("order");

        try {
            builder.addAbove("customer");
            // fail("expecting java.lang.RuntimeException);
        } catch (RuntimeException ignored) {
        }
    }
}
