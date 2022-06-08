package com.perpustakaan.Perpustakaan.controllers.anggota;

import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaDto;
import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.RestResponse;
import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.repositories.AnggotaRepository;
import com.perpustakaan.Perpustakaan.services.anggota.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {

    @Autowired
    private AnggotaRepository anggotaRepository;
    @Autowired
    private AnggotaService anggotaService;

    @GetMapping
    public ResponseEntity<RestResponse<List<Anggota>>> findAllAnggota(){
        return new ResponseEntity<>(
                new RestResponse<>(anggotaRepository.findAll(),
                        anggotaRepository.findAll().size() + " Anggota Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<RestResponse<Anggota>> insertNewAnggota
            (@RequestBody Anggota newAnggota){
        return new ResponseEntity<>(
                new RestResponse<>(anggotaRepository.save(newAnggota),
                        "Berhasil Menambahkan Anggota.",
                        "201"),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean updateAnggota(@RequestBody AnggotaUpdateDto
                                             updateAnggota,
                                 @PathVariable Integer id){
        anggotaService.updateAnggota(updateAnggota, id);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean DeleteAnggotaById(@PathVariable Integer id){
        return anggotaService.DeleteAnggotaById(id);
    }

}
