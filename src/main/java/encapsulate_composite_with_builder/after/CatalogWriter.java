package encapsulate_composite_with_builder.after;

import encapsulate_composite_with_builder.common.Activity;
import encapsulate_composite_with_builder.common.Flavor;
import encapsulate_composite_with_builder.common.Requirement;

public class CatalogWriter {
    private String catalogXmlFor(Activity activity) {
        TagBuilder builder = new TagBuilder("activity");
        builder.addChild("flavors");

        for (int i = 0; i < activity.getFlavorCount(); i++) {
            builder.addToParent("flavors", "flavor");
            Flavor flavor = activity.getFlavor(i);

            // ...

            int requirementsCount = flavor.getRequirements().length;
            if (requirementsCount > 0) {
                builder.addChild("requirements");
                for (int j = 0; j < requirementsCount; j++) {
                    Requirement requirement = flavor.getRequirements()[j];
                    builder.addToParent("requirements", "requirement");
                    // ...
                }
            }
        }
        return builder.toXml();
    }
}
