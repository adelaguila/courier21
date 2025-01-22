package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ordenes_servicios")
public class OrdenServicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idOrdenServicio;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia", nullable = false)
    private AgenciaEntity agencia;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia_destino", nullable = false)
    private AgenciaDestinoEntity destino;

    @ManyToOne //FK
    @JoinColumn(name = "id_cliente_proveedor", nullable = false)
    private ClienteProveedorEntity cliente;

    @Column(length = 100, nullable = false)
    private String remitente;

    @Column(nullable = false)
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
    private Integer piezas;

    @Column(nullable = false)
    private Double peso;

    @Column( nullable = false)
    private Double pesoMinimo;

    private BigDecimal tarifaMinima;

    private BigDecimal tarifaExeso;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_orden_servicio", nullable = false)
    private TipoOrdenServicioEntity tipoOrdenServicio;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_envio", nullable = false)
    private TipoEnvioEntity tipoEnvio;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_servicio", nullable = false)
    private TipoServicioEntity tipoServicio;

    @ManyToOne //FK
    @JoinColumn(name = "id_manifiesto_salida", nullable = true)
    private ManifiestoSalidaEntity manifiestoSalida;

    @ManyToOne //FK
    @JoinColumn(name = "id_manifiesto_reparto", nullable = true)
    private ManifiestoRepartoEntity manifiestoReparto;

    private Long idFacturacion;
    private Long idLiquidacionCliente;
    private Long idLiquidacionAgencia;

    private LocalDateTime fechaHoraRegistro;
    private LocalDateTime fechaHoraEntrega;
    private String recepcionista;
    private String dniRecepcionista;
    private String podVirtual;

}
