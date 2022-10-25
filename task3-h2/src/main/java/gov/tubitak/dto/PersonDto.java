package gov.tubitak.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private Long personId;
    private String firstName;
    private String lastName;
    private List<String> addresses;
}
