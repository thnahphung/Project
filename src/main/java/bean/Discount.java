package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Discount implements Serializable {
    private int discountId;
    private String code;
    private int discountFee;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int quantity;
    private int condition;

    public Discount() {
    }

    public Discount(int discountId, String code, int discountFee, LocalDateTime startDate, LocalDateTime endDate, int quantity, int condition) {
        this.discountId = discountId;
        this.code = code;
        this.discountFee = discountFee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quantity = quantity;
        this.condition = condition;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(int discountFee) {
        this.discountFee = discountFee;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public boolean checkTime() {
        return endDate.isBefore(LocalDateTime.now());
    }

    public boolean checkQuantity() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", code='" + code + '\'' +
                ", discountFee=" + discountFee +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", quantity=" + quantity +
                ", condition=" + condition +
                '}';
    }
}
