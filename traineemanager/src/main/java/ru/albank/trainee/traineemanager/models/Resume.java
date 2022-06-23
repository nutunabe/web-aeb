package ru.albank.trainee.traineemanager.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Resume implements Serializable {
    // Ключ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    // Имя
    private String name;
    // Фамилия
    private String surname;
    // Отчество
    private String patronymic;
    // Адрес
    private String address;
    // Электронный адрес
    private String email;
    // Телефонный номер
    private String phoneNumber;
    // Институт
    private String institute;
    // Группа (Поменял с "group" на "eduGroup" из-за какого-то странного конфликта, который не позволял создать таблицу)
    private String eduGroup;

    public Resume() {}

    public Resume(String name, String surname, String patronymic, String address, String email, String phoneNumber, String institute, String eduGroup) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.institute = institute;
        this.eduGroup = eduGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getEduGroup() {
        return eduGroup;
    }

    public void setEduGroup(String eduGroup) {
        this.eduGroup = eduGroup;
    }

    @Override
    public String toString() {
        return "Resume {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", institute='" + institute + '\'' +
                ", eduGroup='" + eduGroup + '\'' +
                '}';
    }
}
