package com.perpustakaan.Perpustakaan.dtos.petugas;

import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Petugas;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class PetugasDto implements Serializable {
    private final Integer id;
    private final String namaPetugas;
    private final String jabatanPetugas;
    private final String phonePetugas;
    private final String alamatPetugas;

    public static List<PetugasDto> toList(List<Petugas> petugas){
        if(petugas.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<PetugasDto> result =
                petugas.stream().map(PetugasDto::setData);
        return result.toList();
    }

    public static PetugasDto setData(Petugas petugas){
        return new PetugasDto(
                petugas.getId(),
                petugas.getNamaPetugas(),
                petugas.getJabatanPetugas(),
                petugas.getPhonePetugas(),
                petugas.getAlamatPetugas()
        );
    }

    public Petugas convert(){
        return new Petugas(
                namaPetugas,
                jabatanPetugas,
                phonePetugas,
                alamatPetugas
        );
    }
}
