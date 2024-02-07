package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.repository.UserRepository;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;


    @Autowired
    private UserRepository userRepository;


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    public void processRegistration(String name, int age,String email){
        //создается пользователь из параметров метода
        User newUser = userService.createUser(name, age,email);

        // созданный пользователь добавляется в репозиторий
        dataProcessingService.addUserToList(newUser);

        //через notificationService выводится сообщение в консоль
        notificationService.sendNotification("Новый пользователь успешно создан!");
    }
}
