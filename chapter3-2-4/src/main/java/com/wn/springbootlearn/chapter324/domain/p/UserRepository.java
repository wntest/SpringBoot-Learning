package com.wn.springbootlearn.chapter324.domain.p;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
