package replace_implicit_tree_with_composite.after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {
    private List children;
    private String name;
    private String value;
    private StringBuffer attributes;

    public TagNode(String name) {
        this.name = name;
        attributes = new StringBuffer();
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    public void addValue(String value) {
        this.value = value;
    }

    public void add(TagNode child) {
        children().add(child);
    }

    @Override
    public String toString() {
        String result;
        result = "<" + name + attributes + ">";
        Iterator it = children().iterator();
        while (it.hasNext()) {
            TagNode node = (TagNode) it.next();
            result += node.toString();
        }
        result += value;
        result += "</" + name + ">";
        return result;
    }

    private List children() {
        if (children == null) {
            children = new ArrayList();
        }
        return children;
    }
}
