public class Message
{
    String id;
    String content;
    String topicName;
    public Message(String topicName, String content, String id)
    {
        this.content = content;
        this.topicName = topicName;
        this.id = id;
    }
}