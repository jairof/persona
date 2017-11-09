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
public class ObrasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ObrasDTO.class);
    private Integer ano;
    private String argumento;
    private String critica;
    private Integer idobra;
    private String titulo;
    private Integer idautor_Autores;
    private Integer idepoca_Epoca;
    private Integer idgenero_Genero;

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public Integer getIdobra() {
        return idobra;
    }

    public void setIdobra(Integer idobra) {
        this.idobra = idobra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdautor_Autores() {
        return idautor_Autores;
    }

    public void setIdautor_Autores(Integer idautor_Autores) {
        this.idautor_Autores = idautor_Autores;
    }

    public Integer getIdepoca_Epoca() {
        return idepoca_Epoca;
    }

    public void setIdepoca_Epoca(Integer idepoca_Epoca) {
        this.idepoca_Epoca = idepoca_Epoca;
    }

    public Integer getIdgenero_Genero() {
        return idgenero_Genero;
    }

    public void setIdgenero_Genero(Integer idgenero_Genero) {
        this.idgenero_Genero = idgenero_Genero;
    }
}
