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
@Table(name = "tarifario")
public class TarifarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idTarifa;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_CLIENTE_PROVEEDOR"))
    private ClienteProveedorEntity clienteProveedor;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor_area", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_CLIENTE_PROVEEDOR_AREA"))
    private ClienteProveedorAreaEntity clienteProveedorArea;

    @ManyToOne //FK
    @JoinColumn(name = "origen", nullable = false, foreignKey = @ForeignKey(name = "FK_TARIFARIO_ORIGEN"))
    private UbigeoEntity origen;

    @ManyToOne //FK
    @JoinColumn(name = "destino", nullable = false, foreignKey = @ForeignKey(name = "FK_TARIFARIO_DESTINO"))
    private UbigeoEntity destino;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_servicio", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_TIPO_SERVICIO"))
    private TipoServicioEntity tipoServicio;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_TIPO_ENVIO"))
    private TipoEnvioEntity tipoEnvio;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double pesoCondicional;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double tarifaMinima;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double tarifaExeso;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double pesoMinimo;

    @Column(nullable = true)
    private boolean collect;

}
