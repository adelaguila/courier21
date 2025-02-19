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
@Table(name = "recojos_asignaciones")
public class RecojoAsignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idRecojoAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_recojo", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_ASIGNACION_RECOJO"))
    private Recojo recojo;

    private LocalDateTime fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_repartidor", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_ASIGNACION_REPARTIDOR"))
    private User usuarioRepartidor;

    @ManyToOne
    @JoinColumn(name = "id_ayudante", nullable = true, foreignKey = @ForeignKey(name = "FK_RECOJO_ASIGNACION_AYUDANTE"))
    private User usuarioAyudante;

    @ManyToOne
    @JoinColumn(name = "id_unidad_movil", nullable = true, foreignKey = @ForeignKey(name = "FK_RECOJO_ASIGNACION_UNIDAD_MOVIL"))
    private UnidadMovil unidadMovil;

    private String estado;

    private String fechaHoraRecojo;

}
