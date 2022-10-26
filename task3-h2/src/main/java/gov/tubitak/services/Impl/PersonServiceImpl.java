package gov.tubitak.services.Impl;

import gov.tubitak.dto.PersonDto;
import gov.tubitak.entity.Address;
import gov.tubitak.entity.Person;
import gov.tubitak.repositories.AddressRepository;
import gov.tubitak.repositories.PersonRepository;
import gov.tubitak.services.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private Person checkIdInRepository(Long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("! The is not a user with "+id+" id number"));
    }
    private PersonDto addToRepository(Person person, PersonDto personDto){
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        final Person personDb = personRepository.save(person);

        List<Address> listOfAddress = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address adress = new Address();
            adress.setAddress(item);
            adress.setAddressType(Address.AddressType.Other);
            adress.setIsActive(true);
            adress.setPerson(personDb);
            listOfAddress.add(adress);
        });
        addressRepository.saveAll(listOfAddress);
        personDto.setPersonId(personDb.getPersonId());
        return personDto;
    }

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        return addToRepository(person, personDto);
    }
    @Override
    public void deleteById(Long id) {
        checkIdInRepository(id);
        personRepository.deleteById(id);
    }
    @Override
    @Transactional
    public PersonDto update(Long id, PersonDto updatedPerson) {
        Person p = checkIdInRepository(id);
        return addToRepository(p, updatedPerson);
    }

    @Override
    public PersonDto getById(Long id) {
        Person person = checkIdInRepository(id);
        PersonDto personDto = new PersonDto();
        personDto.setPersonId(person.getPersonId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setAddresses(person.getAddresses().stream().map(Address::getAddress)
                .collect(Collectors.toList()));
        return personDto;
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonDto> peopleDto = new ArrayList<>();
        for (Person person : personRepository.findAll()){
            PersonDto personDto = new PersonDto();
            personDto.setPersonId(person.getPersonId());
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setAddresses(person.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            peopleDto.add(personDto);
        }
        return peopleDto;
    }
    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
