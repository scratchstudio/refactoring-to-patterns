package introduce_polymorphic_creation_with_factory_method.after;

import introduce_polymorphic_creation_with_factory_method.common.OutputBuilder;
import introduce_polymorphic_creation_with_factory_method.common.XMLBuilder;

public class XMLBuilderTest extends AbstractBuilderTest {

    @Override
    protected OutputBuilder createBuilder(String rootName) {
        return new XMLBuilder(rootName);
    }
}

