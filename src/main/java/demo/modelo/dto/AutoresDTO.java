package demo.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class AutoresDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AutoresDTO.class);
    private Integer anofallecimiento;
    private Integer anonacimiento;
    private String autor;
    private String estilo;
    private Integer idautor;
    private String lugarnaci;
    private String vida;
    private Integer idepoca_Epoca;

    public Integer getAnofallecimiento() {
        return anofallecimiento;
    }

    public void setAnofallecimiento(Integer anofallecimiento) {
        this.anofallecimiento = anofallecimiento;
    }

    public Integer getAnonacimiento() {
        return anonacimiento;
    }

    public void setAnonacimiento(Integer anonacimiento) {
        this.anonacimiento = anonacimiento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getLugarnaci() {
        return lugarnaci;
    }

    public void setLugarnaci(String lugarnaci) {
        this.lugarnaci = lugarnaci;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public Integer getIdepoca_Epoca() {
        return idepoca_Epoca;
    }

    public void setIdepoca_Epoca(Integer idepoca_Epoca) {
        this.idepoca_Epoca = idepoca_Epoca;
    }
}
