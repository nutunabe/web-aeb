package ru.albank.trainee.traineemanager.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
public class Resume implements Serializable {
    // Идентификатор (является главным ключом)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    // Имя
    private String firstName;
    // Фамилия
    private String secondName;
    // Отчество
    private String patronymic;
    // День рождения
    private LocalDate birthdate;
    // Электронная почта
    private String email;
    // Номер телефона
    private String phoneNumber;
    // Образование
    private String [] education;
    // Учебные работы
    private String eduWorks;
    // Цель
    private String goal;
    // Опыт работы
    private String expWork;
    // Опыт прохождения практик
    private String expPractice;
    // Soft skills
    private String softSkills;
    // Hard skills
    private String hardSkills;
    // Знание языков
    private String langKnowledge;
    // Ссылка на изображение
    private String imgUrl;
    //учебная группа
    private String eduGroup;
    // Статус резюме
    private EResumeStatus resumeStatus;

    public Resume() {}

    public Resume(String firstName, String secondName, String patronymic,
                  LocalDate birthdate, String email, String phoneNumber,
                  String[] education, String eduWorks, String goal, String expWork,
                  String expPractice, String softSkills, String hardSkills,
                  String langKnowledge, String imgUrl, String eduGroup, EResumeStatus resumeStatus) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.education = education;
        this.eduWorks = eduWorks;
        this.goal = goal;
        this.expWork = expWork;
        this.expPractice = expPractice;
        this.softSkills = softSkills;
        this.hardSkills = hardSkills;
        this.langKnowledge = langKnowledge;
        this.imgUrl = imgUrl;
        this.eduGroup = eduGroup;
        this.resumeStatus = resumeStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }

    public String getEduWorks() {
        return eduWorks;
    }

    public void setEduWorks(String eduWorks) {
        this.eduWorks = eduWorks;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getExpWork() {
        return expWork;
    }

    public void setExpWork(String expWork) {
        this.expWork = expWork;
    }

    public String getExpPractice() {
        return expPractice;
    }

    public void setExpPractice(String expPractice) {
        this.expPractice = expPractice;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public String getHardSkills() {
        return hardSkills;
    }

    public void setHardSkills(String hardSkills) {
        this.hardSkills = hardSkills;
    }

    public String getLangKnowledge() {
        return langKnowledge;
    }

    public void setLangKnowledge(String langKnowledge) {
        this.langKnowledge = langKnowledge;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEduGroup() {
        return eduGroup;
    }

    public void setEduGroup(String eduGroup) {
        this.eduGroup = eduGroup;
    }

    public EResumeStatus getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(EResumeStatus resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    @Override
    public String toString() {
        return "Resume {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", education='" + Arrays.toString(education) + '\'' +
                ", eduWorks='" + eduWorks + '\'' +
                ", goal='" + goal + '\'' +
                ", expWork='" + expWork + '\'' +
                ", expPractice='" + expPractice + '\'' +
                ", softSkills='" + softSkills + '\'' +
                ", hardSkills='" + hardSkills + '\'' +
                ", langKnowledge='" + langKnowledge + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", eduGroup='" + eduGroup + '\'' +
                ", resumeStatus='" + resumeStatus + '\'' +
                '}';
    }
}

