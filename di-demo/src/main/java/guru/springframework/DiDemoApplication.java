package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;
import guru.springframework.examplebeans.FakeDataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework"})
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) context.getBean("myController");

        System.out.println(controller.hello());
        System.out.println(context.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(context.getBean(SetterInjectedController.class).sayHello());
        System.out.println(context.getBean(ConstructorInjectedController.class).sayHello());
        
        FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
        System.out.println("");
        System.out.println("Value extracted from a property:");
        System.out.println(fakeDataSource.getUsername());
        System.out.println("");
    }
}
