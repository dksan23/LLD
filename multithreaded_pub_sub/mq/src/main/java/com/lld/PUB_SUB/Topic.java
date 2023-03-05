public class Topic
{
    String name, id;
    List<Message> messages;

    public Topic(String name, String id)
    {
        this.id = id;
        this.name = name;
        messages = new LinkedList<Message>();
    }

    public synchronized void addMessage(@NonNull final Message message) {
        messages.add(message);
    }
}