package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes_proveedores")
public class ClienteProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idClienteProveedor;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_identidad", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_PROVEEDOR_SUNAT_TIPO_DOCUMENTO_IDENTIDAD"))
    private SunatTipoDocumentoIdentidad tipoDocumentoIdentidad;

    @Column(length = 15, nullable = false)
    private String numeroDocumentoIdentidad;

    @Column(length = 150, nullable = false)
    private String nombreRazonSocial;

    private String telefono;

    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_PROVEEDOR_TIPO_CLIENTE_PROVEEDOR"))
    private TipoClienteProveedor tipoClienteProveedor;

    @OneToMany(mappedBy = "clienteProveedor", cascade = CascadeType.ALL)
    private List<ClienteProveedorDireccion> direcciones;

    @OneToMany(mappedBy = "clienteProveedor", cascade = CascadeType.ALL)
    private List<ClienteProveedorArea> areas;

    private boolean activo = true;

}
