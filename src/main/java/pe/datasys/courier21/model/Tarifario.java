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
public class Tarifario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idTarifa;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_CLIENTE_PROVEEDOR"))
    private ClienteProveedor clienteProveedor;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor_area", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_CLIENTE_PROVEEDOR_AREA"))
    private ClienteProveedorArea clienteProveedorArea;

    @ManyToOne //FK
    @JoinColumn(name = "origen", nullable = false, foreignKey = @ForeignKey(name = "FK_TARIFARIO_ORIGEN"))
    private Ubigeo origen;

    @ManyToOne //FK
    @JoinColumn(name = "destino", nullable = false, foreignKey = @ForeignKey(name = "FK_TARIFARIO_DESTINO"))
    private Ubigeo destino;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_servicio", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_TIPO_SERVICIO"))
    private TipoServicio tipoServicio;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = true, foreignKey = @ForeignKey(name = "FK_TARIFARIO_TIPO_ENVIO"))
    private TipoEnvio tipoEnvio;

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
