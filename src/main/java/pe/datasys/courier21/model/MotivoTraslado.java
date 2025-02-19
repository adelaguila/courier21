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
@Table(name = "motivos_traslados")
public class MotivoTraslado {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    private String idMotivoTraslado;

    @Column(length = 100, nullable = false)
    private String nombreMotivoTraslado;

}
