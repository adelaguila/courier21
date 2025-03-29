package pe.datasys.courier21.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdenServicioDTO {
    @EqualsAndHashCode.Include
    @NotNull
    private String idOrdenServicio;
    @NotNull
    private AgenciaDTO agenciaOrigen;
    @NotNull
    private UbigeoDTO origen;
    @NotNull
    private AgenciaDTO agenciaDestino;
    @NotNull
    private UbigeoDTO destino;
    @NotNull
    private ClienteProveedorSimpleDTO cliente;
    private String area;
    @NotNull
    private String remitente;
    @NotNull
    private String consignatario;
    private String idConsignatario;
    @NotNull
    private String direccion;
    private String telefono;
    private String email;
    private String guia;
    private String referencia1;
    private String referencia2;
    private String referencia3;
    private String contenido;
    @NotNull
    private int piezas;
    @NotNull
    private Double peso;
    private Double pesoMinimo;
    private Double tarifaMinima;
    private Double tarifaExeso;
    private Double adicionalPod;
    private Double adicionalTransferencia;
    private Double adicionalOtro;
    private Double subtotal;
    private Double igv;
    private Double total;

    @NotNull
    private String tipoOrdenServicio;
    @NotNull
    private String tipoPago;
    @NotNull
    private String tipoEnvio;
    @NotNull
    private String tipoServicio;
    @NotNull
    private String tipoEmbalaje;

    private Long idManifiestoSalida;
    private Long idManifiestoReparto;
    private Long idFacturacion;
    private Long idLiquidacionCliente;
    private Long idLiquidacionAgencia;

    private LocalDateTime fechaHoraRegistro;
    private LocalDate fechaRegistro;
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
