package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "manifiestos_salidas")
public class ManifiestoSalidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idManifiestoSalida;

    private LocalDateTime fechaHoraRegistro;

    @Column(nullable = true)
    private LocalDateTime fechaHoraCierre;

    @Column(nullable = true)
    private LocalDateTime fechaHoraDespacho;

    @Column(nullable = true)
    private LocalDateTime fechaHoraLlegada;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_origen", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_SALIDA_AGENCIA_ORIGEN"))
    private AgenciaEntity agenciaOrigen;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_REPARTO_AGENCIA_DESTINO"))
    private AgenciaEntity agenciaDestino;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_REPARTO_TIPO_ENVIO"))
    private TipoEnvioEntity tipoEnvio;

    @Column(nullable = true)
    private String nota;

    private String estado;
}
