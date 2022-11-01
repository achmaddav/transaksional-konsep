package com.kelaskoding.demotx.repo;

import com.kelaskoding.demotx.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RekeningRepo extends JpaRepository<Rekening,Long> {

    public Rekening findByNorek(String norek);
}
