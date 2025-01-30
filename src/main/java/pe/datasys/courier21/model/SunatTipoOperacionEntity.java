package pe.datasys.courier21.model;

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
@Table(name = "sunat_tipos_operaciones")
public class SunatTipoOperacionEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    private String idSunatTipoOperacion;

    @Column(length = 150, nullable = false)
    private String nombreTipoOperacion;

}
