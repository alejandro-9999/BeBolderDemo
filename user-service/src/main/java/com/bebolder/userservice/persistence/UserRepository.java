package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.domain.repository.IUserRepository;
import com.bebolder.userservice.persistence.crud.IUserCrudRepository;
import com.bebolder.userservice.persistence.entity.User;
import com.bebolder.userservice.persistence.mappers.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private IUserCrudRepository userCrudRepository;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return userMapper.toUsersDTO(users);
    }

    @Override
    public Optional<UserDTO> getUser(long userId) {
        return userCrudRepository.findById(userId).map(user -> userMapper.userToUserDTO(user));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        return userMapper.userToUserDTO(userCrudRepository.save(user)) ;
    }

    @Override
    public void delete(long userId) {
        userCrudRepository.deleteById(userId);
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userCrudRepository.findByUsername(username).map(user -> userMapper.userToUserDTO(user));
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userCrudRepository.findByEmail(email).map(user -> userMapper.userToUserDTO(user));
    }
}
