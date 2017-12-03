/**
 * Created by EVZabinskaya on 02.12.2017.
 */
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ComponentsFactory {

    private Properties properties;

    public ComponentsFactory() {
        properties = new Properties();
        try {
            properties.load(new FileReader("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Message getMessageComponent() {
        String messageText = properties.getProperty("message.text");
        String className = properties.getProperty("message.class");
        try {
            Class<Message> messageClass = (Class<Message>)Class.forName(className);
            Constructor<Message> messageConstructor = messageClass.getConstructor(String.class);
            Message message = messageConstructor.newInstance(messageText);
            return message;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public MessageRenderer getMessageRendererComponent(Message message) {
        String className = properties.getProperty("renderer.class");
        try {
            Class<MessageRenderer> messageRendererClass = (Class<MessageRenderer>)Class.forName(className);
            Constructor<MessageRenderer> messageRendererConstructor = messageRendererClass.getConstructor(Message.class);
            MessageRenderer messageRenderer = messageRendererConstructor.newInstance(message);
            return messageRenderer;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
