package tk.mwacha.domain.event.product.handler;

import tk.mwacha.domain.event.product.ProductCreatedEvent;
import tk.mwacha.domain.event.shared.EventHandlerInterface;

public class SendEmailWhenProductIsCreatedHandler implements EventHandlerInterface<ProductCreatedEvent> {
    @Override
    public void handle(ProductCreatedEvent event) {
        System.out.println("Sending email to ....");
    }
}
