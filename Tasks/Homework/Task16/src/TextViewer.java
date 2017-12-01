/**
 * Created by EVZabinskaya on 21.11.2017.
 */
class TextViewer {

    private Runnable tasks[];
    private int tasksCount;

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void addTask(Runnable task) {
        tasks[tasksCount] = task;
        tasksCount++;
        Runnable r = () -> {};
    }

    public void process() {
        // ...
    }

    class LettersTask {
       if (text)
    }

}