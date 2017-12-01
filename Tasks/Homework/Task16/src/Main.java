/**
 * Created by EVZabinskaya on 21.11.2017.
*/
public class Main {
    public static void main(String[] args) throws Exception {

        ViewerThread viewerThread = new ViewerThread();
        Thread runnableThread = new Thread(viewerThread);
        runnableThread.start();

        TextViewer viewer = new TextViewer();
       // viewer.setText("Hello, How are you");
        viewer.addTask(new LettersTask());
        viewer.addTask(new DigitsTask());
        viewer.addTask(new PmTask());
        viewer.process();

        viewer.setText("Процесс — это совокупность кода и данных, разделяющих общее виртуальное адресное пространство. Чаще всего одна программа состоит из одного процесса, но бывают и исключения (например, браузер Chrome создает отдельный процесс для каждой вкладки, что дает ему некоторые преимущества, вроде независимости вкладок друг от друга). Процессы изолированы друг от друга, поэтому прямой доступ к памяти чужого процесса невозможен (взаимодействие между процессами осуществляется с помощью специальных средств).");

    }
}
