package tk.mwacha.domain.event.shared;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher implements EventDispatcherInterface {

    @Getter @Builder.Default private Map<String, Object> eventHandlers = new HashMap<>();
    @Override
    public void notify(EventInterface event) {
        final var eventName = event.getClass().getSimpleName();

        if (this.eventHandlers.containsKey(eventName)) {
            this.eventHandlers.forEach((k, v) -> {
                ((EventHandlerInterface)this.eventHandlers.get(k)).handle(event);
            });
        }
    }

    @Override
    public void register(String eventName, EventHandlerInterface eventHandler) {
        if (!this.eventHandlers.containsKey(eventName)) {
            this.eventHandlers.put(eventName,eventHandler);
        }
    }

    @Override
    public void unregister(String eventName, EventHandlerInterface eventHandler) {
        if (this.eventHandlers.containsKey(eventName)) {
            this.eventHandlers.remove(eventName,eventHandler);
        }
    }

    @Override
    public void unregisterAll() {
        this.eventHandlers.clear();
    }
}
