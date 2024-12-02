package com.raressandu.seminar05;


public class Situatie {

    public String disciplina;
    public String activitate;
    public int valoare;
    public double pondere;
    public String data;
    public String descriere;

    public Situatie(String disciplina, String activitate, int valoare, double pondere, String data, String descriere) {
        this.disciplina = disciplina;
        this.activitate = activitate;
        this.valoare = valoare;
        this.pondere = pondere;
        this.data = data;
        this.descriere = descriere;
    }
}
