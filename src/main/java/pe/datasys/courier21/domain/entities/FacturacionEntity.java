package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private String tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_serie_comprobante", nullable = false)
    private SerieComprobanteEntity serieComprobante;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_cliente_proveedor", nullable = false)
    private ClienteProveedorEntity clienteProveedor;

    private String estado;

    private BigDecimal subTotal;
    private BigDecimal igv;
    private BigDecimal total;
    private Boolean collect;

    @ManyToOne
    @JoinColumn(name = "id_agencia_collect", nullable = true)
    private AgenciaEntity agencia;

    private String referencia;
    private String ordenCompra;
    private String pedido;
    private String guia;
    private String moneda;
    private Boolean detraccion;
    private BigDecimal porcentajeDetraccion;
    private String estadoDetraccion;
    private LocalDate fechaPagoDetraccion;

}
