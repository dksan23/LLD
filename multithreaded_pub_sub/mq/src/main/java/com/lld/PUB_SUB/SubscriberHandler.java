import java.util.concurrent.atomic.AtomicInteger;

public class SubscriberHandler
{
    AtomicInteger offset;
    Subscriber subscriber;

    public SubscriberHandler(Subscriber subscriber)
    {
        this.subscriber = subscriber;
        offset = new AtomicInteger(0);
    }

    public void 
}