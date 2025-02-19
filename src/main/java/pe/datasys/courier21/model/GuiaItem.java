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
@Table(name = "guias_items")
public class GuiaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idGuiaItem;

    @ManyToOne
    @JoinColumn(name = "id_guia", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_ITEM_GUIA"))
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_ITEM_UNIDAD_MEDIDA"))
    private UnidadMedida unidadMedida;

    @Column(length = 50, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String glosa;

    private Integer cantidad;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double peso;
}
