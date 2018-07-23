package replace_implicit_tree_with_composite.after;

import replace_implicit_tree_with_composite.common.Order;
import replace_implicit_tree_with_composite.common.Orders;
import replace_implicit_tree_with_composite.common.Product;
import replace_implicit_tree_with_composite.common.ProductSize;

/**
 * 노드를 추가/삭제/포매팅하는 반복적인 코드가 {@link TagNode} 에 캡슐화 됨.
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
        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag = new TagNode("order");
            orderTag.addAttribute("id", String.valueOf(order.getOrderId()));
            writeProductsTo(orderTag, order);
            ordersTag.add(ordersTag);

        }
        xml.append(ordersTag.toString());
    }

    private void writeProductsTo(TagNode orderTag, Order order) {
        for (int i = 0; i < order.getProductCount(); i++) {
            Product product = order.getProduct(i);

            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id", product.getId());
            productTag.addAttribute("color", colorFor(product));

            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                productTag.addAttribute("size", sizeFor(product));
            }

            writePriceTo(productTag, product);
            productTag.addValue(product.getName());
            orderTag.add(productTag);
        }
    }

    private void writePriceTo(TagNode productTag, Product product) {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", currencyFor(product));
        priceTag.addValue(priceFor(product));
        productTag.add(priceTag);
    }

    private String priceFor(Product product) {
        return String.valueOf(product.getPrice());
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
