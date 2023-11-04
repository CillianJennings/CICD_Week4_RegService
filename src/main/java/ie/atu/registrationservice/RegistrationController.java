package ie.atu.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private NotificationService notificationService;

    @Autowired
    public RegistrationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping("/confirm")
    public String confirmDetails(@RequestBody UserDetails userDetails){
        String confirmationMessage = String.format("Received details for %s with email %s",
                userDetails.getName(), userDetails.getEmail() + "  " + notificationService.notification(userDetails));
        return confirmationMessage;
    }


}
