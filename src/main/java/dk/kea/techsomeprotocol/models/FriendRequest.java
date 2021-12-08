package dk.kea.techsomeprotocol.models;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "friend_requests")
public class FriendRequest {
    public FriendRequest(String srcEmail, String srcHost, String desEmail, String desHost) {
        this.srcEmail = srcEmail;
        this.srcHost = srcHost;
        this.desEmail = desEmail;
        this.desHost = desHost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String srcEmail;

    @Column
    private String srcHost;

    @Column
    private String desEmail;

    @Column
    private String desHost;

}
