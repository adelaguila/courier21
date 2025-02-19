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
@Table(name = "manifiestos_repartos_items")
public class ManifiestoRepartoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idManifiestoRepartoItem;

    @ManyToOne //FK
    @JoinColumn(name = "id_manifiesto_reparto", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_REPARTO_ITEM_MANIFIESTO_REPARTO"))
    private ManifiestoReparto manifiestoReparto;

    @ManyToOne //FK
    @JoinColumn(name = "id_orden_servicio", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_REPARTO_ITEM_ORDEN_SERVICIO"))
    private OrdenServicio ordenServicio;

}