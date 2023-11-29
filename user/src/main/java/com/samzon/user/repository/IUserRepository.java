package com.samzon.user.repository;

import com.samzon.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByCode(String code);
    public Optional<User> findByEmail(String email);
    public List<User> findAllByDob(LocalDate dob);
    public List<User> findAllByAge(int age);
}
