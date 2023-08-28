package pos;

public class SaleData {

    private String saleId;
    private String invoiceId;
    private String customerId;
    private String customerName;
    private String totalQty;
    private String totalBill;
    private String status;
    private String balance;

    public SaleData(String saleId, String invoiceId, String customerId, String customerName, String totalQty, String totalBill, String status, String balance) {
        this.saleId = saleId;
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalQty = totalQty;
        this.totalBill = totalBill;
        this.status = status;
        this.balance = balance;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public String getStatus() {
        return status;
    }

    public String getBalance() {
        return balance;
    }
}
