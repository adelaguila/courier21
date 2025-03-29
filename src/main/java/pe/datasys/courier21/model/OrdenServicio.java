package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ordenes_servicios")
public class OrdenServicio {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 50, unique = true)
    private String idOrdenServicio;

    @ManyToOne
    @JoinColumn(name = "agencia_origen", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_SERVICIO_AGENCIA_ORIGEN"))
    private Agencia agenciaOrigen;

    @ManyToOne
    @JoinColumn(name = "origen", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_SERVICIO_ORIGEN"))
    private Ubigeo origen;

    @ManyToOne
    @JoinColumn(name = "agencia_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_SERVICIO_AGENCIA_DESTINO"))
    private Agencia agenciaDestino;

    @ManyToOne
    @JoinColumn(name = "destino", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_SERVICIO_DESTINO"))
    private Ubigeo destino;

    @ManyToOne
    @JoinColumn(name = "id_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDEN_SERVICIO_CLIENTE_PROVEEDOR"))
    private ClienteProveedor cliente;

    @Column(length = 100)
    private String area;

    @Column(length = 100, nullable = false)
    private String remitente;

    @Column(length = 100, nullable = false)
    private String consignatario;

    @Column(length = 15)
    private String idConsignatario;

    @Column(nullable = false)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 150)
    private String email;

    @Column(length = 150)
    private String guia;

    @Column(length = 150)
    private String referencia1;

    @Column(length = 150)
    private String referencia2;

    @Column(length = 150)
    private String referencia3;

    @Column(length = 3, nullable = false)
    private int piezas;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private Double peso;

    @Column(length = 150)
    private String contenido;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double pesoMinimo = 1.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double tarifaMinima = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double tarifaExeso = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double adicionalPod = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double adicionalTransferencia = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double adicionalOtro = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double subtotal = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double igv = 0.0;

    @Column(columnDefinition = "decimal(6, 2)")
    private Double total = 0.0;

    @Column(length = 50, nullable = false)
    private String tipoOrdenServicio;

    @Column(length = 50, nullable = false)
    private String tipoPago;

    @Column(length = 50, nullable = false)
    private String tipoEnvio;

    @Column(length = 50, nullable = false)
    private String tipoServicio;

    @Column(length = 50, nullable = false)
    private String tipoEmbalaje;

    private Long idManifiestoSalida = 0L;
    private Long idManifiestoReparto = 0L;

    private Long idFacturacion = 0L;
    private Long idLiquidacionCliente = 0L;
    private Long idLiquidacionAgencia = 0L;

    private LocalDateTime fechaHoraRegistro;
    private LocalDateTime fechaHoraManifiestoSalida;
    private LocalDateTime fechaHoraDespacho;
    private LocalDateTime fechaHoraLlegada;
    private LocalDateTime fechaHoraReparto;
    private LocalDateTime fechaHoraEntrega;
    private String recepcionista;
    private String dniRecepcionista;
    private String podVirtual;
    private String estadoOperacion;
    private String estadoFacturacion;
}
