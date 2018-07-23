package extract_composite.before;

import extract_composite.common.Node;
import extract_composite.common.Tag;

import java.util.Enumeration;
import java.util.Vector;

public class FormTag extends Tag {
    protected Vector allNodesVector;

    public String toPlainTextString() {
        StringBuffer stringRepresentation = new StringBuffer();
        Node node;
        for (Enumeration e = getAllNodesVector().elements; e.hasMoreElements()) {
            node = (Node) e.nextElement();
            stringRepresentation.append(node.toPlainTextString());
        }
        return stringRepresentation.toString();
    }
}
