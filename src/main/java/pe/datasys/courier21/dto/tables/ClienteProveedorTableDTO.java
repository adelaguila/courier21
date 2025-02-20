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
    private String tipoDocumentoIdentidad;
    private String numeroDocumentoIdentidad;
    private String nombreRazonSocial;
    private String nombreTipoClienteProveedor;
    private String telefono;
    private String correo;
    private boolean activo;
}
