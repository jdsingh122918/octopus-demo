package dev.fermatsolutions;

import io.micronaut.core.annotation.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(nullable = false, name = "surname")
    private String lastName;

    @Nullable
    @Column
    private String firstName;

    @OneToOne(mappedBy = "address")
    private Address address;
}
