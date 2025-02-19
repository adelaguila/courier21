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
@Table(name = "series_comprobantes")
public class SerieComprobante {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String idSerieComprobante;

    @Column(nullable = false)
    private Integer correlativo;

    @ManyToOne
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_SERIE_COMPROBANTE_AGENCIA"))
    private Agencia agencia;

    @Column(length = 4, nullable = false)
    private String codigoSunat;

    private boolean activo;

}
