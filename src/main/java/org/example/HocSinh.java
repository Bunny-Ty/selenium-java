package org.example;

import java.util.Random;
import java.util.UUID;

public class HocSinh {
    private String id;
    private String name;
    private int age;
    private double score;

    public HocSinh(String name, int age, double score) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        this.id = "TVN-AK48" + randomNumber;
        //random student Id with prefix "JVN-AK48"
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void info() {
        System.out.println("student id: " + id);
        System.out.println("student name: " + name);
        System.out.println("student age: " + age);
        System.out.println("student score: " + score);
        System.out.println("student rating: " + rate().getDescription());
        System.out.println("===================================");

    }

    public Rating rate(){
        if (this.score <0 | this.score >10){
            throw new IllegalArgumentException("Invalid score");
        }
        if (this.score <5){
            return Rating.YEU;
        } else if (this.score <6.5){
            return Rating.TRUNG_BINH;
        } else if (this.score <8){
            return Rating.KHA;
        } else if (this.score <9){
            return Rating.GIOI;
        } else {
            return Rating.XUAT_SAC;
        }
    }



}
