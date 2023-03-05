import java.util.concurrent.atomic.AtomicInteger;

public interface Subscriber
{
    String getId();
    void consume(Message message) throws InterruptedException;
}