package encapsulate_classes_with_factory.after;

import encapsulate_classes_with_factory.common.RemoteUser;
import encapsulate_classes_with_factory.common.User;

public class ReferenceDescriptor extends AttributeDescriptor {

    protected ReferenceDescriptor(String createdBy,
                               Class<? extends encapsulate_classes_with_factory.after.Client> aClass,
                               Class<User> userClass,
                               Class<RemoteUser> remoteUserClass) {
        super(/* something */);
    }
}
