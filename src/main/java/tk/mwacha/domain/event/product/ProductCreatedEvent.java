package tk.mwacha.domain.event.product;

import tk.mwacha.domain.event.shared.EventInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductCreatedEvent implements EventInterface {
    private LocalDateTime dateTimeOccurred;
   // T eventData = null;

    public<T> ProductCreatedEvent(T event){
        dateTimeOccurred = LocalDateTime.now();;
      //  eventData = event;
    }
}
