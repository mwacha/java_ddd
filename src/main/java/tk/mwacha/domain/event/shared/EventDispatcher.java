package tk.mwacha.domain.event.shared;

public class EventDispatcher implements EventDispatcherInterface {
    @Override
    public void notify(EventInterface event) {

    }

    @Override
    public void register(String eventName, EventHandlerInterface eventHandler) {

    }

    @Override
    public void unregister(String eventName, EventHandlerInterface eventHandler) {

    }

    @Override
    public void unregisterAll() {

    }
}
