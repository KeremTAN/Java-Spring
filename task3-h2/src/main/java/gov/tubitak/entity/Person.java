package gov.tubitak.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"personId"})
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Long personId;

    @Column(length = 20, name = "first_name")
    private String firstName;

    @Column(length = 20, name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
