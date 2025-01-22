package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @JoinColumn(name = "id_facturacion", nullable = false)
    private FacturacionEntity facturacion;

    @Column(nullable = false)
    private String glosa;

    private Integer cantidad;

    private BigDecimal precio;

    private BigDecimal subTotal;

    private BigDecimal total;
}
