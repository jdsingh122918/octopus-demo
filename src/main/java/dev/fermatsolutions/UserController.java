package dev.fermatsolutions;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;
import lombok.val;
import org.reactivestreams.Publisher;

import javax.validation.Valid;
import java.net.URI;

@Controller(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Publisher<AppUser> show(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @Post
    @Status(HttpStatus.CREATED)
    Publisher<HttpResponse<AppUser>> save(@Valid @Body UserSaveCommand command) {
        val savedEntity = AppUser.builder()
                .lastName(command.getLastName())
                .address(command.getAddress())
                .firstName(command.getFirstName())
                .build();
        return userRepository.save(savedEntity)
                .map(appUser -> HttpResponse
                        .<AppUser>noContent()
                        .headers(header -> header.location(URI.create("/users/" + appUser.getId()))));
    }
}
