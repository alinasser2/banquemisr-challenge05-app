package banquemisr.challenge05.application.controller;

import banquemisr.challenge05.application.dto.LoginDto;
import banquemisr.challenge05.application.dto.RegisterDto;
import banquemisr.challenge05.application.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin()
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        String token = authenticationService.login(loginDto);
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
        String token = authenticationService.register(registerDto);
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok().body(Map.of("message", "Hello World"));
    }
}
