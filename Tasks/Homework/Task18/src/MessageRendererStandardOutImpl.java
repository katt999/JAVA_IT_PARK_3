/**
 * Created by EVZabinskaya on 02.12.2017.
 */
public class MessageRendererStandardOutImpl implements MessageRenderer {

    private Message message;

    public MessageRendererStandardOutImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println(message.getText());
    }
}