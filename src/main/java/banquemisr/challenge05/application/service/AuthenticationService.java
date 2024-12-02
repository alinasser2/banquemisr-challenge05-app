package banquemisr.challenge05.application.service;

import banquemisr.challenge05.application.dto.LoginDto;
import banquemisr.challenge05.application.dto.RegisterDto;

public interface AuthenticationService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
