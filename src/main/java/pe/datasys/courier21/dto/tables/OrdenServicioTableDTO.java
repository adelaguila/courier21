package pe.datasys.courier21.dto.tables;

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
public class OrdenServicioTableDTO {
    @EqualsAndHashCode.Include
    private String idOrdenServicio;
//    private String nombreAgencia;
    private String distrito;
    private String destino;
    private String nombreRazonSocial;
    private String area;
//    private String remitente;
    private String consignatario;
//    private String idConsignatario;
//    private String direccion;
//    private String telefono;
    private String guia;
    private String referencia1;
    private String referencia2;
    private String referencia3;
    private int piezas;
    private Double peso;
//    private Double adicionalTransferencia;
    private Double total;
//    private String tipoOrdenServicio;
//    private String tipoPago;
//    private String tipoEnvio;
//    private String tipoServicio;
    private Long idManifiestoSalida;
    private Long idManifiestoReparto;
    private Long idFacturacion;
    private Long idLiquidacionCliente;
//    private Long idLiquidacionAgencia;
    private LocalDateTime fechaHoraRegistro;
//    private LocalDateTime fechaHoraManifiestoSalida;
//    private LocalDateTime fechaHoraDespacho;
//    private LocalDateTime fechaHoraLlegada;
//    private LocalDateTime fechaHoraReparto;
//    private LocalDateTime fechaHoraEntrega;
//    private String recepcionista;
//    private String dniRecepcionista;
//    private String podVirtual;
    private String estadoOperacion;
    private String estadoFacturacion;
}
