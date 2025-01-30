package pe.datasys.courier21.model;

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
    @JoinColumn(name = "id_cliente_provedor", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_PROVEEDOR_DIRECCION_CLIENTE_PROVEEDOR"))
    private ClienteProveedorEntity clienteProveedor;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ubigeo", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_PROVEEDOR_DIRECCION_UBIGEO"))
    private UbigeoEntity ubigeo;

}
