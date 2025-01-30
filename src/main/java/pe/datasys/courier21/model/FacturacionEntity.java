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
@Table(name = "facturacion")
public class FacturacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFacturacion;

    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_TIPO_PAGO"))
    private TipoPagoEntity tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_serie_comprobante", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_SERIE_COMPROBANTE"))
    private SerieComprobanteEntity serieComprobante;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_sunat_tipo_operacion", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_SUNAT_TIPO_OPERACION"))
    private SunatTipoOperacionEntity sunatTipoOperacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_CLIENTE_PROVEEDOR"))
    private ClienteProveedorEntity clienteProveedor;

    private String direccion;
    private String ubigeo;

    private String estado;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double subTotal;
    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double igv;
    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double total;

    private boolean collect = false;

    @ManyToOne
    @JoinColumn(name = "id_agencia_collect", nullable = true, foreignKey = @ForeignKey(name = "FK_FACTURACION_AGENCIA_COLLECT"))
    private AgenciaEntity agencia;

    @ManyToOne
    @JoinColumn(name = "id_moneda", nullable = true, foreignKey = @ForeignKey(name = "FK_FACTURACION_MONEDA"))
    private MonedaEntity moneda;

    private String referencia;
    private String ordenCompra;
    private String pedido;
    private String guia;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double tipoCambio = 1;
    private boolean detraccion;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double porcentajeDetraccion;

    private String estadoDetraccion;
    private LocalDate fechaPagoDetraccion;

    private String externalId;
    private String documentoAfectado;
    private String notaTipo;
    private String notaMotivo;
    private String respuestaCdr;
    private String linkXml;
    private String linkPdf;
    private String linkCdr;
    private String codigoHash;
    private String codigoQr;

    private String direccionOrigen;
    private String ubigeoOrigen;
    private String direccionDestino;
    private String ubigeoDestino;
    private String detalleViaje;

}
