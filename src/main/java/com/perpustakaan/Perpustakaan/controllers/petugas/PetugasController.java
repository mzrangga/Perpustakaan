package com.perpustakaan.Perpustakaan.controllers.petugas;

import com.perpustakaan.Perpustakaan.dtos.petugas.PetugasDto;
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

    @PutMapping("/update/{idPetugas}")
    public ResponseEntity<RestResponse<PetugasDto>>
    updatePetugas(@PathVariable Integer idPetugas,
                  @RequestBody PetugasUpdateDto updatePetugas) {
        return new ResponseEntity<>(
                new RestResponse<>(petugasService.updatePetugas(updatePetugas, idPetugas),
                        "Data Petugas Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }


    @DeleteMapping("/delete/{idPetugas}")
    public ResponseEntity<RestResponse<PetugasDto>> DeletePetugasById(@PathVariable Integer idPetugas) {
        return new ResponseEntity<>(
                new RestResponse<>(petugasService.delete(idPetugas),
                        "Data Petugas Berhasil Dihapus",
                        "200"),
                HttpStatus.OK);
    }

    @GetMapping("/findById")
    public List<PetugasDto> getIdPetugas(@RequestParam Integer id) {
        return petugasService.findAllPetugasById(id);
    }
}
