package demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "obras", schema = "${schema}")
public class Obras implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idobra;
    @NotNull
    private Autores autores;
    @NotNull
    private Epoca epoca;
    @NotNull
    private Genero genero;
    @NotNull
    private Integer ano;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String argumento;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String critica;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String titulo;

    public Obras() {
    }

    public Obras(Integer idobra, Integer ano, String argumento,
        Autores autores, String critica, Epoca epoca, Genero genero,
        String titulo) {
        this.idobra = idobra;
        this.autores = autores;
        this.epoca = epoca;
        this.genero = genero;
        this.ano = ano;
        this.argumento = argumento;
        this.critica = critica;
        this.titulo = titulo;
    }

    public Integer getIdobra() {
        return this.idobra;
    }

    public void setIdobra(Integer idobra) {
        this.idobra = idobra;
    }

    public Autores getAutores() {
        return this.autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public Epoca getEpoca() {
        return this.epoca;
    }

    public void setEpoca(Epoca epoca) {
        this.epoca = epoca;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getArgumento() {
        return this.argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getCritica() {
        return this.critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
