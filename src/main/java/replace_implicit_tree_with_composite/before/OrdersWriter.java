package replace_implicit_tree_with_composite.before;

import replace_implicit_tree_with_composite.common.Order;
import replace_implicit_tree_with_composite.common.Orders;
import replace_implicit_tree_with_composite.common.Product;
import replace_implicit_tree_with_composite.common.ProductSize;

/**
 * 실질적으로 트리 구조인 데이터를 String 으로 다루고 있음.
 * 중복이 많아지고 태그를 잊지 않고 닫아줘야 하는 등 데이터를 다루기가 복잡해짐.
 * 복잡한 트리 구조로 코드는 점점 비대해짐.
 */
public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order>");
            xml.append(" id=' ");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml, order);
            xml.append("</order>");
        }
        xml.append("</orders>");
    }

    private void writeProductsTo(StringBuffer xml, Order order) {
        for (int i = 0; i < order.getProductCount(); i++) {
            Product product = order.getProduct(i);
            xml.append("<product>");
            xml.append(" id=' ");
            xml.append(product.getId());
            xml.append("'");
            xml.append(" color=' ");
            xml.append(colorFor(product));
            xml.append("'");
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                xml.append(" size='");
                xml.append(sizeFor(product));
                xml.append("'");
            }
            xml.append(">");
            writePriceTo(xml, product);
            xml.append(product.getName());
            xml.append("</product>");
        }
    }

    private void writePriceTo(StringBuffer xml, Product product) {
        xml.append("<price");
        xml.append(" currency='");
        xml.append(currencyFor(product));
        xml.append("'>");
        xml.append(product.getPrice());
        xml.append("</price>");
    }

    private String sizeFor(Product product) {
        //todo something
        throw new UnsupportedOperationException();
    }

    private String colorFor(Product product) {
        //todo something
        throw new UnsupportedOperationException();
    }

    private String currencyFor(Product product) {
        //todo something
        throw new UnsupportedOperationException();
    }
}
