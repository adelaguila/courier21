package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "monedas")
public class MonedaEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 5, nullable = false)
    private String idMoneda;

    @Column(length = 100, nullable = false)
    private String nombreMoneda;

}
