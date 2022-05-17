package com.codeWithAbhi.blog.repository;

import com.codeWithAbhi.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
