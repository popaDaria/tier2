package sep3.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sep3.classes.socketClient.SocketClient;
import sep3.classes.service.UserService;
import sep3.classes.service.UserServiceImpl;
import sep3.classes.socketClient.SocketClientImpl;

@SpringBootApplication
public class ClassesApplication {

    public static void main(String[] args) {
        SocketClient socketClient=new SocketClientImpl();
        UserService dataModel=new UserServiceImpl(socketClient);
        SpringApplication.run(ClassesApplication.class, args);

        //System.out.println(dataModel.addUser(new User()));
        System.out.println(dataModel.getAllUsers());
    }

}
