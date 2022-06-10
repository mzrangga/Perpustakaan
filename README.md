# Perpustakaan
Perpustakaan Mini Rest API

Menggunakan POSTMAN untuk menjalankan nya

URL : http://localhost:8090

Terdapat 4 table :
1. Anggota
2. Buku
3. Petugas
4. Peminjaman

===================================

1. Anggota

Untuk akses table Anggota cara nya :
1. All Anggota : 
- URL : http://localhost:8090/anggota
- METHOD : GET
- PARAMS : -
- BODY : -

2. Insert Anggota :
- URL : http://localhost:8090/anggota/insert
- METHOD : POST
- PARAMS : -
- BODY : raw -> JSON
{
    "kodeAnggota" : "A004",
    "namaAnggota" : "Anggota Baru",
    "jkAnggota" : "L",
    "jurusanAnggota" : "TI",
    "phoneAnggota" : "086555444333",
    "alamat" : "Yogyakarta" 
}

3. Update Anggota
- URL : http://localhost/8090/anggota/update/1 (id 1 sesuai dengan data di insert)
- METHOD : PUT
- PARAMS : -
- BODY : raw -> JSON
{
    "namaAnggota": "Anggota Baru Update"
}

4. Delete Anggota
- URL : http://localhost:8090/anggota/delete/1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : -
- BODY : -

5. Find By Id
- URL : http://localhost:8090/anggota/findById?id=1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : 
    -> KEY : id 
    -> VALUE : 1
- BODY : -

===================================

2. Buku

Untuk akses table Anggota cara nya :
1. All Buku : 
- URL : http://localhost:8090/buku
- METHOD : GET
- PARAMS : -
- BODY : -

2. Insert Buku :
- URL : http://localhost:8090/buku/insert
- METHOD : POST
- PARAMS : -
- BODY : raw -> JSON
{
    "kodeBuku" : "B010",
    "judulBuku" : "Buku Saya",
    "penulisBuku" : "Rangga",
    "penerbitBuku" : "Maulana",
    "tahunPenerbit" : "2022"
}

3. Update Buku
- URL : http://localhost/8090/buku/update/1 (id 1 sesuai dengan data di insert)
- METHOD : PUT
- PARAMS : -
- BODY : raw -> JSON
{
    "judulBuku": "Buku Saya Update"
}

4. Delete Buku
- URL : http://localhost:8090/buku/delete/1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : -
- BODY : -

5. Find By Id
- URL : http://localhost:8090/buku/findById?id=2 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : 
    -> KEY : id 
    -> VALUE : 2
- BODY : -

===================================

3. Petugas

Untuk akses table Anggota cara nya :
1. All Petugas : 
- URL : http://localhost:8090/petugas
- METHOD : GET
- PARAMS : -
- BODY : -

2. Insert Petugas :
- URL : http://localhost:8090/petugas/insert
- METHOD : POST
- PARAMS : -
- BODY : raw -> JSON
{
    "namaPetugas" : "Budi",
    "jabatanPetugas" : "Jabatan Budi",
    "phonePetugas" : "087772626",
    "alamatPetugas" : "Jakarta"
}

3. Update Petugas
- URL : http://localhost/8090/petugas/update/1 (id 1 sesuai dengan data di insert)
- METHOD : PUT
- PARAMS : -
- BODY : raw -> JSON
{
    "namaPetugas": "Budi Update",
    "jabatanPetugas": "Jabatan Budi Update"
}

4. Delete Petugas
- URL : http://localhost:8090/petugas/delete/1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : -
- BODY : -

5. Find By Id
- URL : http://localhost:8090/petugas/findById?id=1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : 
    -> KEY : id 
    -> VALUE : 1
- BODY : -

===================================

4. Peminjaman

Untuk akses table Anggota cara nya :
1. All Peminjaman : 
- URL : http://localhost:8090/peminjaman
- METHOD : GET
- PARAMS : -
- BODY : -

2. Insert Peminjaman :
- URL : http://localhost:8090/peminjaman/insert
- METHOD : POST
- PARAMS : -
- BODY : raw -> JSON
{
    "tanggalPinjam" : "2022-10-15", (Tahun, Bulan, Tanggal)
    "tanggalKembali" : "2022-10-20", (Tahun, Bulan, Tanggal)
    "idBuku" : "1",
    "idAnggota" : "1",
    "idPetugas" : "1"
}

3. Update Peminjaman
- URL : http://localhost/8090/peminjaman/update/1 (id 1 sesuai dengan data di insert)
- METHOD : PUT
- PARAMS : -
- BODY : raw -> JSON
{
    "tanggalKembali": "2022-10-21" (Tahun, Bulan, Tanggal)
}

4. Delete Peminjaman
- URL : http://localhost:8090/peminjaman/delete/1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : -
- BODY : -

5. Find By Id
- URL : http://localhost:8090/peminjaman/findById?id=1 (id 1 sesuai dengan data di insert)
- METHOD : DELETE
- PARAMS : 
    -> KEY : id 
    -> VALUE : 1
- BODY : -
