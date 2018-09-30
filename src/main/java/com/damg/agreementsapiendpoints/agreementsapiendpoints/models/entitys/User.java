package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.entitys;

import com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils.Sexo;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    public Long getId() {
        return id;
    }

    private String sis_user_name;
    private String sis_user_first_name;
    private String sis_user_last_name;
    private String sis_user_middle_name;
    private String sis_user_email;
    private String sis_user_dob;
    private String sis_user_confidentiality_ind;
    private Sexo sis_user_sex;

    public User(String name , String first_name) {
        setSis_user_name(name);
        setSis_user_first_name(first_name);
        setSis_user_last_name("");
        setSis_user_middle_name("");
        setSis_user_email("");
        setSis_user_dob("");
        setSis_user_confidentiality_ind("");
    }

    public User() {

    }

    public String getSis_user_name() {
        return sis_user_name;
    }

    public String getSis_user_first_name() {
        return sis_user_first_name;
    }

    public String getSis_user_last_name() {
        return sis_user_last_name;
    }

    public String getSis_user_middle_name() {
        return sis_user_middle_name;
    }

    public String getSis_user_email() {
        return sis_user_email;
    }

    public String getSis_user_dob() {
        return sis_user_dob;
    }

    public String getSis_user_confidentiality_ind() {
        return sis_user_confidentiality_ind;
    }

    public Sexo getSis_user_sex() {
        return sis_user_sex;
    }

    public void setSis_user_name(String sis_user_name) {
        this.sis_user_name = sis_user_name;
    }

    public void setSis_user_first_name(String sis_user_first_name) {
        this.sis_user_first_name = sis_user_first_name;
    }

    public void setSis_user_last_name(String sis_user_last_name) {
        this.sis_user_last_name = sis_user_last_name;
    }

    public void setSis_user_middle_name(String sis_user_middle_name) {
        this.sis_user_middle_name = sis_user_middle_name;
    }

    public void setSis_user_email(String sis_user_email) {
        this.sis_user_email = sis_user_email;
    }

    public void setSis_user_dob(String sis_user_dob) {
        this.sis_user_dob = sis_user_dob;
    }

    public void setSis_user_confidentiality_ind(String sis_user_confidentiality_ind) {
        this.sis_user_confidentiality_ind = sis_user_confidentiality_ind;
    }

    public void setSis_user_sex(Sexo sis_user_sex) {
        this.sis_user_sex = sis_user_sex;
    }
}
