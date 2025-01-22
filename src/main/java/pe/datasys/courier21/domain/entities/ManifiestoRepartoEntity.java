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
@Table(name = "manifiestos_repartos")
public class ManifiestoRepartoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idManifiestoReparto;

    private LocalDateTime fechaHoraRegistro;

    @Column(nullable = true)
    private LocalDateTime fechaHoraCierre;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia", nullable = false)
    private AgenciaEntity agencia;

    private String estado;
}
