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
@Table(name = "manifiestos_salidas_items")
public class ManifiestoSalidaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idManifiestoSalidaItem;

    @ManyToOne //FK
    @JoinColumn(name = "id_manifiesto_salida", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_SALIDA_ITEM_MANIFIESTO_SALIDA"))
    private ManifiestoSalida manifiestoSalida;

    @ManyToOne //FK
    @JoinColumn(name = "id_orden_servicio", nullable = false, foreignKey = @ForeignKey(name = "FK_MANIFIESTO_SALIDA_ITEM_ORDEN_SERVICIO"))
    private OrdenServicio ordenServicio;

}