CREATE TABLE Anggota(
	Id_Anggota INT PRIMARY KEY IDENTITY NOT NULL,
	Kode_Anggota VARCHAR(10) UNIQUE NOT NULL,
	Nama_Anggota VARCHAR(100) NOT NULL,
	Jk_Anggota VARCHAR(1) NOT NULL,
	Jurusan_Anggota VARCHAR(2) NOT NULL,
	Phone_Anggota VARCHAR(13),
	Alamat VARCHAR(100)
)

CREATE TABLE Petugas(
	Id_Petugas INT PRIMARY KEY IDENTITY NOT NULL,
	Nama_Petugas VARCHAR(100) NOT NULL,
	Jabatan_Petugas VARCHAR(100) NOT NULL,
	Phone_Petugas VARCHAR(13),
	Alamat_Petugas VARCHAR(100)
)

CREATE TABLE Buku(
	id_Buku INT PRIMARY KEY IDENTITY NOT NULL,
	Kode_Buku VARCHAR(10) UNIQUE NOT NULL,
	Judul_Buku VARCHAR(100) NOT NULL,
	Penulis_Buku VARCHAR(50) NOT NULL,
	Penerbit_Buku VARCHAR(50),
	Tahun_Penerbit VARCHAR(4)
)


CREATE TABLE Peminjaman(
	id_Peminjaman INT PRIMARY KEY IDENTITY NOT NULL,
	tanggal_Pinjam DATE NOT NULL,
	tanggal_Kembali DATE NOT NULL,
	id_Buku INT NOT NULL FOREIGN KEY REFERENCES Buku(id_Buku),
	Id_Anggota INT NOT NULL FOREIGN KEY REFERENCES Anggota(Id_anggota),
	Id_Petugas INT NOT NULL FOREIGN KEY REFERENCES Petugas(Id_Petugas)
)

CREATE TABLE Pengembalian(
	id_Pengembalian INT PRIMARY KEY IDENTITY NOT NULL,
	tanggal_Pengembalian DATE NOT NULL,
	id_Buku INT NOT NULL FOREIGN KEY REFERENCES Buku(id_Buku),
	Id_Anggota INT NOT NULL FOREIGN KEY REFERENCES Anggota(Id_Anggota),
	Id_Petugas INT NOT NULL FOREIGN KEY REFERENCES Petugas(Id_Petugas)
)