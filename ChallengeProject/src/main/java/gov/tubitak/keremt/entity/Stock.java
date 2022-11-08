package gov.tubitak.keremt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stockTable")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Stock {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String date;

    @Column
    private String symbol;

    @Column
    private BigDecimal open;

    @Column
    private BigDecimal high;

    @Column
    private BigDecimal low;

    @Column
    private BigDecimal close;

    @Column
    private BigDecimal volume;
}
