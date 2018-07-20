package encapsulate_classes_with_factory.after;

import encapsulate_classes_with_factory.common.RemoteUser;
import encapsulate_classes_with_factory.common.User;

import java.util.Date;

public abstract class AttributeDescriptor {

    protected AttributeDescriptor() {
    }

    public static AttributeDescriptor forInteger(String remoteId,
                                                 Class<? extends Client> aClass) {
        return new DefaultDescriptor(remoteId, aClass, Integer.TYPE);
    }

    public static AttributeDescriptor forDate(String createdDate,
                                              Class<? extends Client> aClass) {
        return new DefaultDescriptor(createdDate, aClass, Date.class);
    }

    public static AttributeDescriptor forUser(String createdBy, Class<? extends Client> aClass) {
        return new ReferenceDescriptor(createdBy, aClass, User.class, RemoteUser.class);
    }
}
