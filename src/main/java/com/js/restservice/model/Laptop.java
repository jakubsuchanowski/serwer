package com.js.restservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laptop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa_producenta")
    private String nazwaProducenta;
    @Column(name = "przekatna_ekranu")
    private String przekatnaEkranu;
    @Column(name = "rozdzielczosc")
    private String rozdzielczosc;
    @Column(name = "rodzaj_ekranu")
    private String rodzajEkranu;
    @Column(name = "czy_dotykowy")
    private String czyDotykowy;
    @Column(name = "nazwa_procesora")
    private String nazwaProcesora;
    @Column(name = "liczba_rdzeni")
    private String liczbaRdzeni;
    @Column(name = "taktowanie")
    private String taktowanie;
    @Column(name = "pamiec_ram")
    private String pamiecRam;
    @Column(name = "pojemnosc_dysku")
    private String pojemnoscDysku;
    @Column(name = "rodzaj_dysku")
    private String rodzajDysku;
    @Column(name = "nazwa_ug")
    private String nazwaUg;
    @Column(name = "pamiec_ug")
    private String pamiecUg;
    @Column(name = "nazwa_so")
    private String nazwaSo;
    @Column(name = "rodzaj_napedu")
    private String rodzajNapedu;

}
