package dk.kea.techsomeprotocol.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "relations")
@Entity
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @ManyToOne
    @JoinColumn(name = "user_one_id")
    private User userOne;

    @ManyToOne
    @JoinColumn(name = "user_two_id")
    private User userTwo;

    @Column
    private boolean friends;

    @Column
    private boolean blocked;
}
