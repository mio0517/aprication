package com.example.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { //主キー型式integer
  
@Query(
  value ="SELECT * FROM user ORDER BY id DESC",
  nativeQuery = true
)  

public List<UserEntity> findAllOrderByidDesc();
}