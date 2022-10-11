package dev.fermatsolutions;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Introspected
@Getter
public class UserSaveCommand {

    @NotBlank
    private String lastName;

    @Nullable
    private String firstName;

    @Nullable
    private Address address;
}
