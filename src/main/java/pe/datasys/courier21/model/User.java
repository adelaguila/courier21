package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(length = 160, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "id_sunat_tipo_documento_identidad", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_SUNAT_TIPO_DOCUMENTO_IDENTIDAD"))
    private SunatTipoDocumentoIdentidad sunatTipoDocumentoIdentidad;

    @Column(length = 20, nullable = false)
    private String numeroDocumentoIdentidad;

    @Column(length = 20, nullable = true)
    private String licencia;

    @Column(length = 20)
    private String telefono;

    private String foto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "idUser", foreignKey = @ForeignKey(name = "FK_USER_ROLE_USER")),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole", foreignKey = @ForeignKey(name = "FK_USER_ROLE_ROLE"))
    )
    private List<Role> roles;
}
