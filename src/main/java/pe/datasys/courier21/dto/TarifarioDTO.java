package pe.datasys.courier21.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarifarioDTO {
    @EqualsAndHashCode.Include
    private Long idTarifario;

    private ClienteProveedorDTO clienteProveedor;
    private ClienteProveedorAreaDTO clienteProveedorArea;

    @NotNull
    private UbigeoDTO origen;

    @NotNull
    private UbigeoDTO destino;

    @NotNull
    private TipoServicioDTO tipoServicio;

    @NotNull
    private TipoEnvioDTO tipoEnvio;

    private double pesoCondicional;

    private double tarifaMinima;
    private double tarifaExeso;
    private double pesoMinimo;

    private boolean collect;
}
