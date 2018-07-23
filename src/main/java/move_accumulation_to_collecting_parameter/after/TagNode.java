package move_accumulation_to_collecting_parameter.after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 비대 했던 {@link move_accumulation_to_collecting_parameter.before.TagNode#toString()} 메서드가
 * 여러 작은 메서드로 분해되고 정보를 축적하는 지역변수 StringBuffer 를 계속 전달하며 정보를 축적하도록 변경 됨.
 */
public class TagNode {
    private List children;
    private String name;
    private String value;
    private StringBuffer attributes;

    // ...

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        appendContentsTo(result);

        return result.toString();
    }

    private void appendContentsTo(StringBuffer result) {
        writeOpenTagTo(result);
        writeChildrenTo(result);
        writeValueTo(result);
        writeEndTagTo(result);
    }

    private void writeOpenTagTo(StringBuffer result) {
        result.append("<");
        result.append(name);
        result.append(attributes.toString());
        result.append(">");
    }

    private void writeChildrenTo(StringBuffer result) {
        Iterator it = children().iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            node.appendContentsTo(result);
        }
    }

    private void writeValueTo(StringBuffer result) {
        if (!value.equals("")) {
            result.append(value);
        }
    }

    private void writeEndTagTo(StringBuffer result) {
        result.append("</");
        result.append(name);
        result.append(">");
    }

    private List children() {
        if (children == null) {
            children = new ArrayList();
        }
        return children;
    }
}
