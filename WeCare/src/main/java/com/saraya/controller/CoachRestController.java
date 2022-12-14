package com.saraya.controller;

import com.saraya.DTO.BookingDto;
import com.saraya.DTO.CoachDto;
import com.saraya.DTO.LoginDto;
import com.saraya.DTO.UserDto;
import com.saraya.service.BookService;
import com.saraya.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping( "/coaches")
@CrossOrigin(origins = "http://localhost:4200")
public class CoachRestController {

    @Autowired
    CoachService coachService;

    @Autowired
    BookService bookService;

    @PostMapping(value = "/saveCoach" )
    public ResponseEntity<String> createCoach(@Valid @RequestBody CoachDto coachDTO, Errors errors) {
        String response = "";
        if (errors.hasErrors())
        {
            response  = errors.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));

            return ResponseEntity.ok(response);
        }
        else
        {
            response = coachService.createCoach(coachDTO);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> loginCoach(@RequestBody LoginDto loginDTO) throws Exception {


        if (!coachService.loginCoach(loginDTO)) {
            ResponseEntity.ok(false);

        }
        return ResponseEntity.ok(coachService.loginCoach(loginDTO) );

    }

    @GetMapping("/coach/{coachId}")
    public ResponseEntity<CoachDto> getCoachProfile(@PathVariable String coachId){

//        This method is used to send user DTO for a given user id with status OK.

        return ResponseEntity.ok(coachService.getCoachProfile(coachId));

    }

    @GetMapping("/allcoach")
    public List<CoachDto> showAllCoaches(){

//        This method is used to send list of all coach DTO.

        return coachService.showAllCoaches();

    }

    @GetMapping("/booking/{coachId}")
    public List<BookingDto> showMySchedule(@PathVariable String coachId){
        return bookService.findBookingByCoachId(coachId);
    }

//@GetMapping("/readTodo")
//public List<Todo> GetAllTodo() {
//    return repo.findAll();
//}

}
