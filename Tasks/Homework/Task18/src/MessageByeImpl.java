/**
 * Created by EVZabinskaya on 02.12.2017.
 */
public class MessageByeImpl implements Message {
    private String text;

    public MessageByeImpl(String text) {
        this.text = "Bye, " + text;
    }

    public String getText() {
        return text;
    }
}
