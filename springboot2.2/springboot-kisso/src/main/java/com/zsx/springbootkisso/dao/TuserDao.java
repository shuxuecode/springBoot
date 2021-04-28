package com.zsx.springbootkisso.dao;

import com.zsx.springbootkisso.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuserDao extends JpaRepository<Tuser, Integer> {

    List<Tuser> findByDeleted(Integer deleted);

    List<Tuser> findByDeletedAndUsername(Integer deleted, String username);

    List<Tuser> findByDeletedAndId(Integer deleted, Integer id);
}
