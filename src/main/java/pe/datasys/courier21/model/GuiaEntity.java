package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "guias")
public class GuiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idGuia;

    private LocalDate fechaEmision;
    private LocalDate fechaTraslado;

    @ManyToOne
    @JoinColumn(name = "id_sunat_tipo_documento", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_SUNAT_TIPO_DOCUMENTO"))
    private SunatTipoDocumento sunatTipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_serie_comprobante", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_SERIE_COMPROBANTE"))
    private SerieComprobanteEntity serieComprobante;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_remitente", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_REMITENTE"))
    private ClienteProveedorEntity remitente;

    @ManyToOne
    @JoinColumn(name = "id_destinatario", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_DESTINATARIO"))
    private ClienteProveedorEntity destinatario;

    @ManyToOne
    @JoinColumn(name = "id_modalidad_traslado", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_MODALIDAD_TRASLADO"))
    private ModalidadTrasladoEntity modalidadTraslado;

    @ManyToOne
    @JoinColumn(name = "id_motivo_traslado", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_MOTIVO_TRASLADO"))
    private MotivoTrasladoEntity motivoTraslado;

    private String descripcionMotivoTraslado;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_UNIDAD_MEDIDA"))
    private UnidadMedidaEntity unidadMedida;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double pesoTotal;

    private Integer piezas;

    private String observaciones;

    private String ordenPedido;

    private String puntoPartida;
    private String ubigeoPuntoPartida;

    private String puntoLlegada;
    private String ubigeoPuntoLlegada;

    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_CONDUCTOR"))
    private User conductor;

    @ManyToOne
    @JoinColumn(name = "id_unidad_movil", nullable = false, foreignKey = @ForeignKey(name = "FK_GUIA_UNIDAD_MOVIL"))
    private UnidadMovilEntity unidadMovil;

    private String placaSemiRemolque;

    private String linkXml;
    private String linkPdf;
    private String linkCdr;

}
