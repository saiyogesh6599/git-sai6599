package Project1.UberX.services;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.SignUPDTO;
import Project1.UberX.dto.UserDTO;
import Project1.UberX.entity.Roles;
import Project1.UberX.entity.Users;
import Project1.UberX.repository.UsersRepo;

@Service
public class AuthServiceImpl implements AuthService {

	private ModelMapper modelMapper;
	private UsersRepo userRepo;
	private RiderService riderService;

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public UserDTO signup(SignUPDTO signUPDTO) {
		Users user = userRepo.findByEmail(signUPDTO.getEmail());
		if (user != null) {
			throw new RuntimeException("cannot signup, User already exists with email " + signUPDTO.getEmail());
		}
		Users mappedUser = modelMapper.map(signUPDTO, Users.class);
		user.setRoles(Set.of(Roles.RIDER));
		Users savedUser = userRepo.save(user);

		// create user
		riderService.createNewRider(savedUser);
		// TODO add Wallet Service rela

		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public DriverDTO onBoardNewDriver(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
