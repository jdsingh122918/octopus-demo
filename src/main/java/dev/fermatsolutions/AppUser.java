package dev.fermatsolutions;

import io.micronaut.core.annotation.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "appuser")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @SequenceGenerator(name = "appuser_id_seq", sequenceName = "appuser_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_id_seq")
    private Long id;

    @NotBlank
    @Column(nullable = false, name = "surname")
    private String lastName;

    @Nullable
    @Column(name = "firstname")
    private String firstName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
