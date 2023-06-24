package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDTO {
    private String id;
    private String name;
    private String address;

    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHandd;

    private String orderId;
    private LocalDate orderDate;
    private String customerId;

    private String Oid;
    private String itemCode;
    private int qty;

    public CustomDTO() {
    }

    public CustomDTO(String id, String name, String address, String code, String description, BigDecimal unitPrice, int qtyOnHandd, String orderId, LocalDate orderDate, String customerId, String oid, String itemCode, int qty) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHandd = qtyOnHandd;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        Oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHandd() {
        return qtyOnHandd;
    }

    public void setQtyOnHandd(int qtyOnHandd) {
        this.qtyOnHandd = qtyOnHandd;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHandd=" + qtyOnHandd +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                ", Oid='" + Oid + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                '}';
    }
}
