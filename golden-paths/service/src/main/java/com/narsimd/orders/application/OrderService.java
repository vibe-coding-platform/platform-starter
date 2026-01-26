@Service
public class OrderService {
    @SagaOrchestrator
    public Mono<OrderSaga> placeOrder(OrderCommand cmd) {
        return saga.start(cmd)
            .reserveInventory()
            .chargePayment()
            .shipOrder();
    }
}
