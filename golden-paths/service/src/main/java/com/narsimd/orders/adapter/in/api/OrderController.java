package com.ndurai.orders.adapter.in.api;

import com.ndurai.orders.application.OrderService;
import com.ndurai.orders.domain.OrderRequest;
import com.ndurai.orders.domain.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(
    name = "Orders",
    description = "Order API – saga-ready, observability-friendly, AI-decision compatible"
)
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(
        summary = "Create a new order",
        description = "Creates an order and starts the saga orchestration (reserve inventory, charge payment, ship).",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Order created",
                content = @Content(schema = @Schema(implementation = OrderResponse.class))
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Invalid request payload"
            )
        }
    )
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @Valid @RequestBody OrderRequest request
    ) {
        OrderResponse response = orderService.placeOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "Get order by ID",
        description = "Returns the current state of an order, including saga status (PENDING, COMPLETED, COMPENSATED).",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Order found",
                content = @Content(schema = @Schema(implementation = OrderResponse.class))
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Order not found"
            )
        }
    )
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(
            @Parameter(description = "Order ID", required = true)
            @PathVariable("orderId") @NotBlank String orderId
    ) {
        return orderService
                .getOrder(UUID.fromString(orderId))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Cancel an order",
        description = "Cancels the order and triggers saga compensation if needed (refund, release inventory).",
        responses = {
            @ApiResponse(
                responseCode = "202",
                description = "Cancellation accepted"
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Order not found"
            )
        }
    )
    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(
            @Parameter(description = "Order ID", required = true)
            @PathVariable("orderId") @NotBlank String orderId
    ) {
        boolean accepted = orderService.cancelOrder(UUID.fromString(orderId));
        if (!accepted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }
}
