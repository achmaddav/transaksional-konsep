package com.kelaskoding.demotx.service;

import com.kelaskoding.demotx.dto.TransferReq;
import com.kelaskoding.demotx.entity.Rekening;
import com.kelaskoding.demotx.repo.RekeningRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RekeningService {

    private final RekeningRepo rekeningRepo;

    public Rekening create(Rekening rekening) {
        return rekeningRepo.save(rekening);
    }

    public Iterable<Rekening> findAll() {
        return  rekeningRepo.findAll();
    }

    @Transactional
    public void transfer(TransferReq transferReq) {
        Rekening rekening1 = rekeningRepo.findByNorek(transferReq.getNorek1());
        if (rekening1==null) {
            throw new RuntimeException("Norek1 tidak valid");
        }
        if (rekening1.getSaldo()<transferReq.getSaldo()) {
            throw new RuntimeException("Saldo tidak cukup");
        }
        rekening1.setSaldo(rekening1.getSaldo()-transferReq.getSaldo());
        rekeningRepo.save(rekening1);

        Rekening rekening2 = rekeningRepo.findByNorek(transferReq.getNorek2());
        if (rekening2==null) {
            throw new RuntimeException("Norek2 tidak valid");
        }
        rekening2.setSaldo(rekening2.getSaldo()+transferReq.getSaldo());
        rekeningRepo.save(rekening2);
    }
}
