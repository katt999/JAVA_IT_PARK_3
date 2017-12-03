/**
 * Created by EVZabinskaya on 02.12.2017.
 */
public class MainComponentsFactoryImpl {
    public static void main(String[] args) {
        ComponentsFactory factory = new ComponentsFactory();
        Message message = factory.getMessageComponent();
        System.out.println(message.getText());
        MessageRenderer serrRenderer = factory.getMessageRendererComponent(message);
        serrRenderer.render();
    }
}