package pe.datasys.courier21.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sunat_tipos_documentos")
public class SunatTipoDocumento {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    private String idSunatTipoDocumento;
    
    @Column(length = 150, nullable = false)
    private String nombreSunatTipoDocumento;

}
