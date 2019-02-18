package com.yy.repository;

import com.yy.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 通过年龄查询
    public List<Girl> findByAge(Integer age);

    // 通过id查询
    public Optional<Girl> findById(Integer id);
}
