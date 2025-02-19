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
@Table(name = "modalidades_traslados")
public class ModalidadTraslado {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    private String idModalidadTraslado;

    @Column(length = 100, nullable = false)
    private String nombreModalidadTraslado;

}
