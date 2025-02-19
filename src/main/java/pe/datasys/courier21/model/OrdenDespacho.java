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
@Table(name = "ordenes_despachos")
public class OrdenDespacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idOrdenDespacho;

    private LocalDate fechaRegistro;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_origen", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_DESPACHO_AGENCIA_ORIGEN"))
    private Agencia agenciaOrigen;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_DESPACHO_AGENCIA_DESTINO"))
    private Agencia agenciaDestino;

    @ManyToOne //FK
    @JoinColumn(name = "id_despacho_valija", nullable = true, foreignKey = @ForeignKey(name = "FK_ORDEN_DESPACHO_DESPACHO_VALIJA"))
    private DespachoValija despachoValija;

    @Column(nullable = false)
    private String consignatario;

    @Column(nullable = false)
    private Integer piezas;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double peso;

}
