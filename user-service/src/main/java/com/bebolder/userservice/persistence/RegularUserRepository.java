package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.repository.IRegularUserRepository;
import com.bebolder.userservice.persistence.crud.IRegularUserCrudRepository;
import com.bebolder.userservice.persistence.entity.RegularUser;
import com.bebolder.userservice.persistence.mappers.IRegularUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegularUserRepository implements IRegularUserRepository {
    @Autowired
    private IRegularUserCrudRepository regularUserCrudRepository;

    @Autowired
    private IRegularUserMapper regularUserMapper;

    @Override
    public List<RegularUserDTO> getAll() {
        List<RegularUser> regularUsers = (List<RegularUser>) regularUserCrudRepository.findAll();
        return regularUserMapper.toRegularUsersDTO(regularUsers);
    }

    @Override
    public Optional<RegularUserDTO> getRegularUser(long regularUserId) {
        return regularUserCrudRepository.findById(regularUserId).map(regularUser -> regularUserMapper.regularUserToRegularUserDTO(regularUser));
    }

    @Override
    public RegularUserDTO save(RegularUserDTO regularUserDTO) {
        RegularUser regularUser = regularUserMapper.regularUserDTOToRegularUser(regularUserDTO);
        return regularUserMapper.regularUserToRegularUserDTO(regularUserCrudRepository.save(regularUser));
    }

    @Override
    public void delete(long regularUserId) {
        regularUserCrudRepository.deleteById(regularUserId);
    }

    @Override
    public Optional<RegularUserDTO> findByUsername(String username) {
        return this.regularUserCrudRepository.findByUsername(username).map(regularUser -> this.regularUserMapper.regularUserToRegularUserDTO(regularUser));
    }

    @Override
    public Optional<RegularUserDTO> findByEmail(String email) {
        return this.regularUserCrudRepository.findByEmail(email).map(regularUser -> this.regularUserMapper.regularUserToRegularUserDTO(regularUser));
    }
}
