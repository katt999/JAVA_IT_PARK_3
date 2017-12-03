/**
 * Created by EVZabinskaya on 02.12.2017.
 */
public class MessageErrorOutImpl implements MessageRenderer {
    private Message message;

    public MessageErrorOutImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.err.println(message.getText());
    }
}