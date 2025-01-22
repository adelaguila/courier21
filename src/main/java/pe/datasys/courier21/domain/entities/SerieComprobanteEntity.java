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
@Table(name = "series_comprobantes")
public class SerieComprobanteEntity {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String idSerieComprobante;

    @Column(nullable = false)
    private Integer correlativo;

    @ManyToOne
    @JoinColumn(name = "id_agencia", nullable = false)
    private AgenciaEntity agencia;

    @Column(length = 4, nullable = false)
    private String codigoSunat;

    private Boolean activo;

}
