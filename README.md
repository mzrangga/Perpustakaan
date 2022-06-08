# Perpustakaan
Perpustakaan Mini Rest API

Gunakan POSTMAN untuk menjalankan nya

URL : http://localhost:8090

Terdapat 3 table :
1. Anggota
2. Petugas
3. Buku

Untuk akses table Anggota cara nya :
1. All Anggota : 
- URL : http://localhost:8090/anggota
- METHOD : GET
- PARAMS : -
- BODY : -

2. Insert Anggota :
- URL : http:localhost:8090/anggota/insert
- METHOD : POST
- PARAMS : -
- BODY : raw -> JSON
{
    "kodeAnggota" : "A005",
    "namaAnggota" : "Nama Anggota",
    "jkAnggota" : "L",
    "jurusanAnggota" : "TI",
    "phoneAnggota" : "086555444333",
    "alamat" : "Cirebon" 
}

3. Update Anggota
- URL : http://localhost/8090/anggota/update/1
- METHOD : PUT
- PARAMS : -
- BODY : raw -> JSON
{
    "namaAnggota": "mzrangga"
}

4. Delete Anggota
- URL : http://localhost:8090/anggota/delete/1
- METHOD : DELETE
- PARAMS : -
- BODY : -
