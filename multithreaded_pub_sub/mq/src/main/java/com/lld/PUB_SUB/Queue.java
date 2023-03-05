public class Queue
{
    final Map<String, TopicHandler> topics;

    public Queue()
    {
        topics = new HashMap<>();
    }

    public Topic addTopic(@NonNull String topicName)
    {
        final TopicHandler topicHandler = new TopicHandler(topicName);
        
    }

    public void publish(@NonNull Message message)
    {
        // publish to all the subscribers for the topic in message
    }

    public 
}