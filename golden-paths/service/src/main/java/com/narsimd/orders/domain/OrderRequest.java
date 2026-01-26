package com.ndurai.orders.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Order creation request")
public class OrderRequest {

    @NotBlank
    @Schema(description = "Customer identifier", example = "cust-12345")
    private String customerId;

    @NotBlank
    @Schema(description = "Product identifier", example = "prod-98765")
    private String productId;

    @NotNull
    @Schema(description = "Quantity ordered", example = "2")
    private Integer quantity;

    // Default constructor for JSON deserialization
    public OrderRequest() {}

    // Getters/Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}