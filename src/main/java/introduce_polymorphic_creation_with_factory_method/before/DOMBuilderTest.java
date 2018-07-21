package introduce_polymorphic_creation_with_factory_method.before;

import introduce_polymorphic_creation_with_factory_method.common.DOMBuilder;
import introduce_polymorphic_creation_with_factory_method.common.OutputBuilder;
import introduce_polymorphic_creation_with_factory_method.common.XMLBuilder;

/**
 * {@link DOMBuilder}와 {@link XMLBuilder}를 테스트를 위한 동일한 테스트 메서드가 9개가 넘게 있음.
 * 한 쪽이 수정되면 나머지 한쪽도 똑같이 수정을 해줘야 함.
 */
public class DOMBuilderTest {
    private OutputBuilder builder;

    public void testAddAboveRoot() {
        //language=HTML
        String invalidResult =
                "<orders>\n" +
                "    <order>\n" +
                "    </order>\n" +
                "</orders>\n" +
                "<customer>\n" +
                "</customer>";

        builder = new DOMBuilder("orders");
        builder.addBelow("order");

        try {
            builder.addAbove("customer");
            // fail("expecting java.lang.RuntimeException);
        } catch (RuntimeException ignored) {
        }
    }

    // 그 외 몇가지 테스트 케이스들
}

