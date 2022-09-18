package tk.mwacha.domain.event.product;

import lombok.Getter;
import tk.mwacha.domain.event.shared.EventInterface;

import java.time.LocalDateTime;


public class ProductCreatedEvent implements EventInterface {
    private LocalDateTime dateTimeOccurred;
    private Object eventData;

    public ProductCreatedEvent(Object event){
        dateTimeOccurred = LocalDateTime.now();;
        eventData = event;
    }
}
