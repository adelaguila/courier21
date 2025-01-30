package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reportes")
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idReporte;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_REPORTE_AGENCIA"))
    private AgenciaEntity agencia;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_REPORTE_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reporte", nullable = false, foreignKey = @ForeignKey(name = "FK_REPORTE_TIPO_REPORTE"))
    private TipoReporteEntity tipoReporte;

    @Column(nullable = false)
    private String recepcionista;

    @Column()
    private String nota;

}
