package gov.tubitak.controllers;

import gov.tubitak.dto.PersonDto;
import gov.tubitak.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return  ResponseEntity.ok(personService.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id){
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable(value = "id") Long id, @RequestBody PersonDto updatedPerson){
        return ResponseEntity.ok(personService.update(id, updatedPerson));
    }

}
