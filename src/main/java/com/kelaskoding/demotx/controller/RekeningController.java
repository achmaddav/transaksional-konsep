package com.kelaskoding.demotx.controller;

import com.kelaskoding.demotx.dto.TransferReq;
import com.kelaskoding.demotx.entity.Rekening;
import com.kelaskoding.demotx.service.RekeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rekening")
public class RekeningController {

    private final RekeningService rekeningService;

    @PostMapping
    public Rekening create(@RequestBody Rekening rekening) {
        return rekeningService.create(rekening);
    }

    @GetMapping
    public Iterable<Rekening> findAll() {
        return rekeningService.findAll();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferReq transferReq) {
        rekeningService.transfer(transferReq);
    }
}
