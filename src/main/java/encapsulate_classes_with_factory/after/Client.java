package encapsulate_classes_with_factory.after;

import static encapsulate_classes_with_factory.after.AttributeDescriptor.forDate;
import static encapsulate_classes_with_factory.after.AttributeDescriptor.forInteger;
import static encapsulate_classes_with_factory.after.AttributeDescriptor.forUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 클라이언트는 {@link AttributeDescriptor}가 제공하는 인터페이슬르 통해 서브클래스 인스턴스를 얻음.
 * 클라이언트가 {@link AttributeDescriptor}의 서브클래스를 직접 생성하지 않음.
 * 서브클래스들의 생성자는 모두 protected 로 변경 되어 수퍼클래스를 통해서만 접근 가능함.
 */
public class Client {

    protected List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(forInteger("remoteId", getClass()));
        result.add(forDate("createdDate", getClass()));
        result.add(forDate("lastChangedDate", getClass()));
        result.add(forUser("createdBy", getClass()));
        result.add(forInteger("optimisticLockVersion", getClass()));

        return result;
    }

}
