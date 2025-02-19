package pe.datasys.courier21.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteProveedorDireccionDTO {
    @EqualsAndHashCode.Include
    private Long idClienteProveedorDireccion;

    @JsonBackReference
    private ClienteProveedorDTO clienteProveedor;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 200, message = "{direccion.size}")
    private String direccion;

    private UbigeoDTO ubigeo;
}
