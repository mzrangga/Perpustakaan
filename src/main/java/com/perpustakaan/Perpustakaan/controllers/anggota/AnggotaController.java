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

//    Cek update menggunakan Boolean
//    @PutMapping("/update/{id}")
//    public Boolean updateAnggota(@RequestBody AnggotaUpdateDto
//                                             updateAnggota,
//                                 @PathVariable Integer id){
//        anggotaService.updateAnggota(updateAnggota, id);
//        return true;
//    }

    @PutMapping("/update/{idAnggota}")
    public ResponseEntity<RestResponse<AnggotaDto>> updateAnggota
            (@PathVariable Integer idAnggota,
             @RequestBody AnggotaUpdateDto updateAnggota){
        return new ResponseEntity<>(
                new RestResponse<>(anggotaService.updateAnggota
                        (updateAnggota, idAnggota),
                        "Data Anggota Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idAnggota}")
    public ResponseEntity<RestResponse<AnggotaDto>> DeleteAnggotaById
            (@PathVariable Integer idAnggota){
        return new ResponseEntity<>(
                new RestResponse<>(
                        anggotaService.deleteAnggotaById(idAnggota),
                        "Data Anggota Berhasil Dihapus",
                        "200"),
                HttpStatus.OK);
    }
}
