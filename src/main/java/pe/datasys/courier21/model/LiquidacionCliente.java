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
@Table(name = "liquidaciones_clientes")
public class LiquidacionCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idLiquidacionCliente;

    private LocalDate fecha;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_LIQUIDACION_CLIENTE_AGENCIA"))
    private Agencia agencia;


    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_LIQUIDACION_CLIENTE_CLIENTE_PROVEEDOR"))
    private ClienteProveedor clienteProveedor;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor_area", nullable = true, foreignKey = @ForeignKey(name = "FK_LIQUIDACION_CLIENTE_CLIENTE_PROVEEDOR_AREA"))
    private ClienteProveedorArea clienteProveedorArea;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = false, foreignKey = @ForeignKey(name = "FK_LIQUIDACION_CLIENTE_TIPO_ENVIO"))
    private TipoEnvio tipoEnvio;

    @Column(nullable = true)
    private String nota;

    private String estado;
}
