package gov.tubitak.keremt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* RestController is Rest Api
* RestController connect the class as controller to outside world
* RequestMapping set url address of the controller(class)
*/
@RestController
@RequestMapping("/first")
public class FirstApi {

    @GetMapping //this method will work when a get request is made to 0.0.0.0:8080 thanks to this annotation
    public String first(){
        return "task 3-1 has been done!";
    }
}
