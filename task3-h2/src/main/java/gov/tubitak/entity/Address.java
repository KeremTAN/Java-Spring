package gov.tubitak.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"addressId"})
@ToString
public class Address {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long addressId;

    @Column(length = 300, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_address_id")
    private Person person;

    public enum AddressType{
        Home,
        WorkPlace,
        Other
    }
}
