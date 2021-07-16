package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spring.boot.demo.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public abstract AppUser findByUsername(String username);

}
