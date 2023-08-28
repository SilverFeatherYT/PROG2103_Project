package pos;

public class ProductData {
    private String id;
    private String name;
    private String barcode;
    private String price;
    private String qty;

    public ProductData(String id, String name, String barcode, String price, String qty) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }
}
