package pos;

public class CartData {
    private String invoiceId;
    private String productName;
    private String barcode;
    private String productQty;
    private String unitPrice;
    private String totalPrice;

    public CartData(String invoiceId, String productName, String barcode, String productQty, String unitPrice, String totalPrice) {
        this.invoiceId = invoiceId;
        this.productName = productName;
        this.barcode = barcode;
        this.productQty = productQty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
