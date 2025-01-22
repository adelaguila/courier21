package pe.datasys.courier21.domain.entities;

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
    @JoinColumn(name = "id_agencia_origen", nullable = false)
    private AgenciaEntity agenciaOrigen;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_destino", nullable = false)
    private AgenciaEntity agenciaDestino;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = false)
    private TipoEnvioEntity tipoEnvio;

    @Column(nullable = true)
    private String nota;

    private String estado;
}
