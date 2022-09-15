package tk.mwacha.domain.event.shared;

public interface EventDispatcherInterface {
    void notify(EventInterface event);
    void register(String eventName, EventHandlerInterface eventHandler);
    void unregister(String eventName, EventHandlerInterface eventHandler);
    void unregisterAll();
}
