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
@Table(name = "clientes_proveedores_areas")
public class ClienteProveedorArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idClienteProveedorArea;

    @ManyToOne
    @JoinColumn(name = "id_cliente_provedor", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_PROVEEDOR_AREA_CLIENTE_PROVEEDOR"))
    private ClienteProveedor clienteProveedor;

    @Column(nullable = false, length = 50)
    private String area;

    @Column(length = 50)
    private String contacto;

    @Column(length = 50)
    private String telefonoContacto;

    @Column(length = 50)
    private String emailContacto;

}
