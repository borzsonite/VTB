package com.lesson9.homework;

@Table(title = "Student")
public class Student {
    @Column(columnName = "id")
    private int id;
    @Column(columnName = "name")
    private String name;
    @Column(columnName = "score")
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
