package com.zsx.springboot.dao;

import com.zsx.springboot.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Tuser, Integer> {
}
