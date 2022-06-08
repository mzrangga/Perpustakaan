package com.perpustakaan.Perpustakaan.controllers.petugas;

import com.perpustakaan.Perpustakaan.dtos.petugas.PetugasUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.RestResponse;
import com.perpustakaan.Perpustakaan.models.Petugas;
import com.perpustakaan.Perpustakaan.repositories.PetugasRepository;
import com.perpustakaan.Perpustakaan.services.petugas.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petugas")
public class PetugasController {
    @Autowired
    private PetugasRepository petugasRepository;
    @Autowired
    private PetugasService petugasService;

    @Autowired
    public PetugasController(PetugasRepository petugasRepository) {
        this.petugasRepository = petugasRepository;
    }

    @RequestMapping
    public ResponseEntity<RestResponse<List<Petugas>>> findAllPetugas() {
        return new ResponseEntity<>(
                new RestResponse<>(petugasRepository.findAll(),
                        petugasRepository.findAll().size() + " Petugas Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<RestResponse<Petugas>> insertNewPetugas
            (@RequestBody Petugas newPetugas) {
        return new ResponseEntity<>(
                new RestResponse<>(petugasRepository.save(newPetugas),
                        "Berhasil Menambahkan Petugas.",
                        "201"),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean updatePetugas(@RequestBody PetugasUpdateDto
                                             updatePetugas,
                                 @PathVariable Integer id) {
        petugasService.updatePetugas(updatePetugas, id);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean DeletePetugasById(@PathVariable Integer id) {
        return petugasService.DeletePetugasById(id);
    }
}
