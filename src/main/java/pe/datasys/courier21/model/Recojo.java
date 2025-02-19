package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "recojos")
public class Recojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 5, nullable = false)
    private Long idRecojo;

    @Column(length = 100, nullable = false)
    private String nombreMoneda;

    private LocalDateTime fechaHoraRegistro;

    @ManyToOne
    @JoinColumn(name = "id_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_CLIENTE_PROVEEDOR"))
    private ClienteProveedor clienteProveedor;

    private String contacto;
    private String contactoTelefono;
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_TIPO_PAGO"))
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_tipo_unidad_movil", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_TIPO_UNIDAD_MOVIL"))
    private TipoUnidadMovil tipoUnidadMovil;

    @ManyToOne
    @JoinColumn(name = "id_tipo_envio", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_TIPO_ENVIO"))
    private TipoEnvio tipoenvio;

    private Boolean multipleConsignatatio;

    private String consignatartio;
    private String consignatarioDireccion;
    private String consignatarioTelefono;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_UBIGEO_DESTINO"))
    private Ubigeo ubigeoDestino;

    private Boolean collectAceptado;
    private String horarioRecojo;
    private String referenciaRecojo;

    @ManyToOne
    @JoinColumn(name = "id_recojo_estado", nullable = false, foreignKey = @ForeignKey(name = "FK_RECOJO_RECOJO_ESTADO"))
    private RecojoEstado estado;

    private LocalDateTime fechaHoraRecojo;

}
