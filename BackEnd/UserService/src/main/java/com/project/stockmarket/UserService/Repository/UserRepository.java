package com.project.stockmarket.UserService.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmarket.UserService.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUsername(String username);

	public Optional<UserEntity> findByEmail(String email);

	public Optional<UserEntity> findByUsernameAndPassword(String username, String password);
	
//	@Query("SELECT confirmed FROM UserEntity WHERE username=?1")
//	public boolean isUserActive(String username);

}
