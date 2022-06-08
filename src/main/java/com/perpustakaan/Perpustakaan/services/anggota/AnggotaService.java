package com.perpustakaan.Perpustakaan.services.anggota;

import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaDto;
import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaUpdateDto;
import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    private AnggotaRepository anggotaRepository;

    public List<AnggotaDto> findAllAnggota() {
        return AnggotaDto.toList(anggotaRepository.findAll());
    }

    public AnggotaDto insertAnggota(AnggotaDto newAnggota) {
        Anggota anggota = newAnggota.convert();
        anggotaRepository.save(anggota);
        return AnggotaDto.setData(anggota);
    }

//    public Boolean updateAnggota(AnggotaUpdateDto updateAnggota,
//                                 Integer idAnggota) {
//        Anggota anggota = anggotaRepository.findById(idAnggota)
//                .orElseThrow(
//                () -> new RuntimeException("Anggota tidak ditemukan"));
//
//        anggota.setNamaAnggota(updateAnggota.getNamaAnggota());
//        anggotaRepository.save(anggota);
//        return true;
//    }

    public AnggotaDto updateAnggota(AnggotaUpdateDto updateAnggota,Integer idAnggota
                                 ) {
        Anggota anggota = anggotaRepository.findById(idAnggota)
                .orElseThrow(() -> new RuntimeException("Anggota tidak ditemukan"));

        anggota.setNamaAnggota(updateAnggota.getNamaAnggota()
        == null ? anggota.getNamaAnggota() : updateAnggota.getNamaAnggota());

        anggotaRepository.save(anggota);
        return AnggotaDto.setData(anggota);
    }




    public boolean DeleteAnggotaById(Integer id){
        anggotaRepository.deleteById(id);
        return true;
    }


}
