package demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "autores", schema = "${schema}")
public class Autores implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idautor;
    @NotNull
    private Epoca epoca;
    @NotNull
    private Integer anofallecimiento;
    @NotNull
    private Integer anonacimiento;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String autor;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String estilo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String lugarnaci;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String vida;
    private Set<Obras> obrases = new HashSet<Obras>(0);

    public Autores() {
    }

    public Autores(Integer idautor, Integer anofallecimiento,
        Integer anonacimiento, String autor, Epoca epoca, String estilo,
        String lugarnaci, Set<Obras> obrases, String vida) {
        this.idautor = idautor;
        this.epoca = epoca;
        this.anofallecimiento = anofallecimiento;
        this.anonacimiento = anonacimiento;
        this.autor = autor;
        this.estilo = estilo;
        this.lugarnaci = lugarnaci;
        this.vida = vida;
        this.obrases = obrases;
    }

    public Integer getIdautor() {
        return this.idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public Epoca getEpoca() {
        return this.epoca;
    }

    public void setEpoca(Epoca epoca) {
        this.epoca = epoca;
    }

    public Integer getAnofallecimiento() {
        return this.anofallecimiento;
    }

    public void setAnofallecimiento(Integer anofallecimiento) {
        this.anofallecimiento = anofallecimiento;
    }

    public Integer getAnonacimiento() {
        return this.anonacimiento;
    }

    public void setAnonacimiento(Integer anonacimiento) {
        this.anonacimiento = anonacimiento;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getLugarnaci() {
        return this.lugarnaci;
    }

    public void setLugarnaci(String lugarnaci) {
        this.lugarnaci = lugarnaci;
    }

    public String getVida() {
        return this.vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public Set<Obras> getObrases() {
        return this.obrases;
    }

    public void setObrases(Set<Obras> obrases) {
        this.obrases = obrases;
    }
}
