package com.example.cruduser.dao;

import com.example.cruduser.model.Passport;
import com.example.cruduser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Long> {

}
