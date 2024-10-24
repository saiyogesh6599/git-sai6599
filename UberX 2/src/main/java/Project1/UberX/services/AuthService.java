package Project1.UberX.services;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.SignUPDTO;
import Project1.UberX.dto.UserDTO;


public interface AuthService {

	String login(String email, String password);
	UserDTO signup(SignUPDTO signUPDTO);
	DriverDTO onBoardNewDriver(Long userId);
}
