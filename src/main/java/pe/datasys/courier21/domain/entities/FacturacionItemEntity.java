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
@Table(name = "clientes_poveedores_direcciones")
public class ClienteProveedorDireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idClienteProveedorDireccion;

    @ManyToOne
    @JoinColumn(name = "id_cliente_provedor", nullable = false)
    private ClienteProveedorEntity clienteProveedor;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ubigeo", nullable = false)
    private UbigeoEntity ubigeo;

}
