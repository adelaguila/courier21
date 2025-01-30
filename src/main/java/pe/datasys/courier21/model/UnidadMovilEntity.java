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
@Table(name = "unidades_moviles")
public class UnidadMovilEntity {
    @Id
    @EqualsAndHashCode.Include
    private String idUnidadMovil;

    @ManyToOne
    @JoinColumn(name = "id_tipo_unidad_movil", nullable = false, foreignKey = @ForeignKey(name = "FK_UNIDAD_MOVIL_TIPO_UNIDAD_MOVIL"))
    private TipoUnidadMovilEntity tipoUnidadMovil;

    @Column(length = 100, nullable = false)
    private String nombreUnidadMovil;

    private String modelo;

    private String marca;
}
