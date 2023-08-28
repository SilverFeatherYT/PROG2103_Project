package pos;

public class SaleDatabase extends DatabaseActions {

    public static void addSale(SaleData data) {
        String query = "INSERT INTO sales (INID, Cid, Customer_Name, Total_Qty, Total_Bill, Status, Balance) "
                + "VALUES ('" + data.getInvoiceId() + "','" + data.getCustomerId() + "','" + data.getCustomerName() + "','" + data.getTotalQty() + "','" + data.getTotalBill() + "','" + data.getStatus() + "','" + data.getBalance() + "')";
        executeUpdate(query);
    }

    public static void addCartItem(CartData data) {
        String query = "INSERT INTO cart (INID, D_CartProductName, D_CartBarcode, D_CartProductQty, D_CartUnitPrice, D_CartTotalPrice) "
                + "VALUES ('" + data.getInvoiceId() + "','" + data.getProductName() + "','" + data.getBarcode() + "','" + data.getProductQty() + "','" + data.getUnitPrice() + "','" + data.getUnitPrice() + "')";
        executeUpdate(query);
    }

}
