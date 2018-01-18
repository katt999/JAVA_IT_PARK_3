package execute;

import component.Print;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by EVZabinskaya on 18.01.2018.
 */
public class Execute {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Print print = (Print)context.getBean("print");
        print.showSquare();
    }
}
