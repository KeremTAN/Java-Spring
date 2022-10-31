package gov.tubitak.keremt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Stock {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String symbol ="IBM";

    @Column
    @JsonProperty("1. open")
    private BigDecimal open;

    @Column
    @JsonProperty("2. high")
    private BigDecimal high;

    @Column
    @JsonProperty("3. low")
    private BigDecimal low;

    @Column
    @JsonProperty("4. close")
    private BigDecimal close;

    @Column
    @JsonProperty("5. volume")
    private BigDecimal volume;
}
