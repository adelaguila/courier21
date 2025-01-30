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
@Table(name = "facturacion_items")
public class FacturacionItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFacturacionItem;

    @ManyToOne
    @JoinColumn(name = "id_facturacion", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_ITEM_FACTURACION"))
    private FacturacionEntity facturacion;

    @Column(nullable = false)
    private String glosa;

    private Integer cantidad;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double precio;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double subTotal;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double total;
}
