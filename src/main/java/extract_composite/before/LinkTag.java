package extract_composite.before;

import extract_composite.common.Node;
import extract_composite.common.Tag;

import java.util.Enumeration;
import java.util.Vector;

public class LinkTag extends Tag {
    protected Vector nodeVector;

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;
        for (Enumeration e = linkData(); e.hasMoreElements()) {
            node = (Node) e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }
}
