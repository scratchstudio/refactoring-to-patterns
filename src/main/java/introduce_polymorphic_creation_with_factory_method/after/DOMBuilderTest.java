package introduce_polymorphic_creation_with_factory_method.after;

import introduce_polymorphic_creation_with_factory_method.common.DOMBuilder;
import introduce_polymorphic_creation_with_factory_method.common.OutputBuilder;

public class DOMBuilderTest extends AbstractBuilderTest {

    @Override
    protected OutputBuilder createBuilder(String rootName) {
        return new DOMBuilder(rootName);
    }
}

