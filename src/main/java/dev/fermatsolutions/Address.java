package dev.fermatsolutions;

import io.micronaut.core.annotation.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(nullable = false, name = "zipcode")
    private String zipcode;

    @Nullable
    @Column(name = "city")
    private String city;
}
