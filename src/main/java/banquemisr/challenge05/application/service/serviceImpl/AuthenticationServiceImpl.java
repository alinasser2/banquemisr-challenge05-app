package banquemisr.challenge05.application.service.serviceImpl;

import banquemisr.challenge05.application.config.JwtService;
import banquemisr.challenge05.application.dto.LoginDto;
import banquemisr.challenge05.application.dto.RegisterDto;
import banquemisr.challenge05.application.entity.User;
import banquemisr.challenge05.application.enums.Roles;
import banquemisr.challenge05.application.repository.UserRepository;
import banquemisr.challenge05.application.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();
        return jwtService.generateToken(Map.of(), user);
    }

    @Override
    public String register(RegisterDto registerDto) {
        User user = User.builder()
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .roles(Roles.USER)
                .build();
        userRepository.save(user);

        return jwtService.generateToken(Map.of(), user);
    }


}
