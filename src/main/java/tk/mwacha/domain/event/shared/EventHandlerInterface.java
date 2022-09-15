package tk.mwacha.domain.event.shared;

public interface EventHandlerInterface<T extends EventInterface> {
    void handle(T event);
}
