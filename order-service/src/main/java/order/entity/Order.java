package order.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private String orderId;
    private String productId;
    private String customerId;
    private String status;
    private Timestamp createTime;
    private Timestamp finishTime;
}
