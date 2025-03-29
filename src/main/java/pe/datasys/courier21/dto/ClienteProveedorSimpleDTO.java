package pe.datasys.courier21.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteProveedorSimpleDTO {
    @EqualsAndHashCode.Include
    private Long idClienteProveedor;

    @NotNull
    private SunatTipoDocumentoIdentidadDTO tipoDocumentoIdentidad;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 15)
    private String numeroDocumentoIdentidad;

    @NotNull
    @Size(min = 2, max = 150)
    private String nombreRazonSocial;

    private String telefono;

    private String correo;

    @NotNull
    private TipoClienteProveedorDTO tipoClienteProveedor;

    @NotNull
    private boolean activo;

}
