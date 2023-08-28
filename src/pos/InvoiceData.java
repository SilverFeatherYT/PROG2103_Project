package pos;

public class InvoiceData {
    private String saleID;
    private String inid;
    private String cid;
    private String customerName;
    private String totalQty;
    private String totalBill;
    private String status;
    private String balance;

    public InvoiceData(String saleID, String inid, String cid, String customerName, String totalQty, String totalBill, String status, String balance) {
        this.saleID = saleID;
        this.inid = inid;
        this.cid = cid;
        this.customerName = customerName;
        this.totalQty = totalQty;
        this.totalBill = totalBill;
        this.status = status;
        this.balance = balance;
    }

    public String getSaleID() {
        return saleID;
    }

    public String getInid() {
        return inid;
    }

    public String getCid() {
        return cid;
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
