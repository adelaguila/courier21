package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "despachos_valijas")
public class DespachoValijaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idDespachoValija;

    private LocalDate fechaRegistro;
    
    @ManyToOne //FK
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_DEPACHO_VALIJA_AGENCIA"))
    private AgenciaEntity agencia;

    @ManyToOne //FK
    @JoinColumn(name = "id_user_chofer", nullable = false, foreignKey = @ForeignKey(name = "FK_DESPACHO_VALIJA_CHOFER"))
    private User chofer;

    @ManyToOne //FK
    @JoinColumn(name = "id_user_ayudante", nullable = true, foreignKey = @ForeignKey(name = "FK_DESPACHO_VALIJA_AYUDANTE"))
    private User ayudante;

    @ManyToOne //FK
    @JoinColumn(name = "id_unidad_movil", nullable = false, foreignKey = @ForeignKey(name = "FK_DESPACHO_VALIJA_UNIDAD_MOVIL"))
    private UnidadMovilEntity unidadMovil;

    private LocalDateTime fechaHoraSalida;

    private String referencia;

}
