package pe.datasys.courier21.dto.tables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.datasys.courier21.dto.ClienteProveedorDireccionDTO;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteProveedorTableDTO {
    @EqualsAndHashCode.Include
    private Long idClienteProveedor;

    @NotNull
    @Size(max = 5)
    private String tipoDocumentoIdentidad;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 15)
    private String numeroDocumentoIdentidad;

    @NotNull
    @Size(min = 2, max = 150)
    private String nombreRazonSocial;

    @NotNull
    private Integer idTipoClienteProveedor;

    @NotNull
    private boolean activo;
}
