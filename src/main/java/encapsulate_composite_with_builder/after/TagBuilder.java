package encapsulate_composite_with_builder.after;

import encapsulate_composite_with_builder.common.TagNode;

/**
 * 빌더를 적용하기 전 컴포지트 패턴을 적용한 예제는 {@link replace_implicit_tree_with_composite.after.OrdersWriter}를 참고.
 * 컴포짓 구조를 생성하는 작업은 반복적이고 복잡하며 에러를 유발하기 쉬운 경우가 많기 때문에 빌더를 통해 캡슐화 함.
 *
 * 성능 문제로 인해 BufferSize 를 관리하는 로직도 나중에 추가되었지만 모두 캡슐화 되어 있기 때문에 외부의 인터페이스는 변하지 않음.
 */
public class TagBuilder {
    private static int TAG_CHARS_SIZE = 5;
    private static int ATTRIBUTE_CHARS_SIZE = 4;

    private int outputBufferSize;

    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
        currentNode = rootNode;

        incrementBufferSizeByTagLength(rootTagName);
    }

    public void addToParent(String parentTagName, String childTagName) {
        TagNode parentNode = findParentBy(parentTagName);
        if (parentNode == null) {
            throw new RuntimeException("missing parent tag: " + parentTagName);
        }
        addTo(parentNode, childTagName);
    }

    public void addAttribute(String name, String value) {
        currentNode.addAttribute(name, value);
        incrementBufferSizeByAttributeLength(name, value);
    }

    public void addValue(String value) {
        currentNode.addValue(value);
        incrementBufferSizeByValueLength(value);
    }

    public void addChild(String childTagName) {
        addTo(currentNode, childTagName);
    }

    public void addSibling(String siblingTagName) {
        addTo(currentNode.getParent(), siblingTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }

    private void addTo(TagNode parentNode, String tagName) {
        currentNode = new TagNode(tagName);
        parentNode.add(currentNode);

        incrementBufferSizeByTagLength(tagName);
    }

    private TagNode findParentBy(String parentTagName) {
        TagNode parentNode = currentNode;
        while (parentNode != null) {
            if (parentNode.equals(parentNode.getName())) {
                return parentNode;
            }

            parentNode = parentNode.getParent();
        }
        return null;
    }

    private void incrementBufferSizeByAttributeLength(String name, String value) {
        outputBufferSize += (name.length() + value.length() + ATTRIBUTE_CHARS_SIZE);
    }

    private void incrementBufferSizeByTagLength(String tag) {
        int sizeOfOpenAndCloseTags = tag.length() * 2;
        outputBufferSize += sizeOfOpenAndCloseTags + TAG_CHARS_SIZE;
    }

    private void incrementBufferSizeByValueLength(String value) {
        outputBufferSize += value.length();
    }
}
