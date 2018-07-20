package encapsulate_classes_with_factory.before;

import encapsulate_classes_with_factory.common.RemoteUser;
import encapsulate_classes_with_factory.common.User;

public class ReferenceDescriptor extends AttributeDescriptor {

    public ReferenceDescriptor(String createdBy,
                               Class<? extends Client> aClass,
                               Class<User> userClass,
                               Class<RemoteUser> remoteUserClass) {
        super(/* something */);
    }
}
