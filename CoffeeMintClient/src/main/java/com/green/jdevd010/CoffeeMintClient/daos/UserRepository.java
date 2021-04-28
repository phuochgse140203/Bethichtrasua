package com.green.jdevd010.CoffeeMintClient.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.green.jdevd010.CoffeeMintClient.models.Coffeemint;

public interface UserRepository extends CrudRepository<Coffeemint, Integer> {
	@Query("SELECT u FROM Coffeemint WHERE  u.username = :username")
	public Coffeemint getUserByUsername(@Param("username")String username);
	
}
