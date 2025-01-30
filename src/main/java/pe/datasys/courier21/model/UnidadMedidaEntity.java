package pe.datasys.courier21.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "unidades_medidas")
public class UnidadMedidaEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 5, nullable = false)
    private String idUnidadMedida;

    @Column(length = 100, nullable = false)
    private String nombreUnidadMedida;

}
