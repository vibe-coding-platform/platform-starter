package com.ndurai.orders.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order response with saga status")
public class OrderResponse {

    @Schema(example = "b9c3a4f0-7e5d-4c4b-9b7e-1a2f3d4c5b6a")
    private String orderId;

    @Schema(example = "PENDING") // PENDING, COMPLETED, COMPENSATED
    private String status;

    @Schema(example = "cust-12345")
    private String customerId;

    @Schema(example = "prod-98765")
    private String productId;

    private Integer quantity;

    // Default constructor
    public OrderResponse() {}

    // Constructor for service layer
    public OrderResponse(String orderId, String status, String customerId, 
                        String productId, Integer quantity) {
        this.orderId = orderId;
        this.status = status;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public String getCustomerId() { return customerId; }
    public String getProductId() { return productId; }
    public Integer getQuantity() { return quantity; }
}