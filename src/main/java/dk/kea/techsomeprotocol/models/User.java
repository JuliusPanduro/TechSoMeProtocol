package dk.kea.techsomeprotocol.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author Julius Panduro
 */
@Data
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    private Long Id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String domain;

    @OneToMany(mappedBy = "Id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Relation> relations;

}
