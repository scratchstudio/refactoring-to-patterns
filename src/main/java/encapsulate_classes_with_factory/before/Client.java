package encapsulate_classes_with_factory.before;

import encapsulate_classes_with_factory.common.RemoteUser;
import encapsulate_classes_with_factory.common.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Client.
 */
public class Client {

    /**
     * 관계형 데이터베이스에서 객체를 읽어 들이거나 저장하는데 사용되는 매핑 코드
     */
    protected List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(new DefaultDescriptor("remoteId", getClass(), Integer.TYPE));
        result.add(new DefaultDescriptor("createdDate", getClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate", getClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy", getClass(), User.class, RemoteUser.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", getClass(), Integer.TYPE));

        // DefaultDescriptor, ReferenceDescriptor, BooleanDescriptor 등 실제로는 10여 종류가 있음

        return result;
    }
}
