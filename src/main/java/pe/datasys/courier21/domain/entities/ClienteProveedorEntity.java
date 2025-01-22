package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes_poveedores")
public class ClienteProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idClienteProveedor;

    @Column(length = 5, nullable = false)
    private String tipoDocumentoIdentidad;

    @Column(length = 15, nullable = false)
    private String numeroDocumentoIdentidad;

    @Column(nullable = false)
    private String nombreRazonSocial;

}
