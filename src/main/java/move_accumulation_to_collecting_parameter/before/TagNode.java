package move_accumulation_to_collecting_parameter.before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * {@link TagNode#toString()} 메서드는 각 노드를 재귀적으로 방문해
 * XML 트리의 문자열 표현을 생성함. 이를 위해 굉장히 많은 일을 하고 있음.
 */
public class TagNode {
    private List children;
    private String name;
    private String value;
    private StringBuffer attributes;

    // ...

    @Override
    public String toString() {
        String result = "<" + name + attributes + ">";
        Iterator it = children().iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            result += node.toString();
        }

        if (!value.equals("")) {
            result += value;
            result += "</" + name + ">";
        }
        return result;
    }

    private List children() {
        if (children == null) {
            children = new ArrayList();
        }
        return children;
    }
}
