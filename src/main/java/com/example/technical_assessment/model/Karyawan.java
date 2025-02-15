package com.example.technical_assessment.model;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "karyawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_karyawan", nullable = false, length = 100)
    private String namaKaryawan;

    @Column(name = "jabatan", nullable = false, length = 50)
    private String jabatanKaryawan;

    @Column(name = "user_id", unique = true)
    private Integer userId;

    @Column(name = "created_at", updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getter and Setter ID karyawan
    public Integer getId(){ 
        return id; 
    }

    public void setId(Integer id){ 
        this.id = id; 
    }

    // Getter and Setter Nama karyawan
    public String getNamaKaryawan(){ 
        return namaKaryawan; 
    }

    public void setNamaKaryawan(String namaKaryawan){ 
        this.namaKaryawan = namaKaryawan;
    }

    // Getter and Setter Jabatan karyawan
    public String getJabatanKaryawan(){ 
        return jabatanKaryawan; 
    }

    public void setJabatanKaryawan(String jabatanKaryawan){ 
        this.jabatanKaryawan = jabatanKaryawan; 
    }

    // Getter and Setter User ID karyawan
    public Integer getUserId(){ 
        return userId; 
    }

    public void setUserId(Integer userId){ 
        this.userId = userId; 
    }

    // Getter tanggal dibuat
    public LocalDateTime getCreatedAt(){ 
        return createdAt; 
    }
}