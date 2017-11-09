package demo.presentation.businessDelegate;

import demo.modelo.Autores;
import demo.modelo.Epoca;
import demo.modelo.Genero;
import demo.modelo.Obras;

import demo.modelo.control.AutoresLogic;
import demo.modelo.control.EpocaLogic;
import demo.modelo.control.GeneroLogic;
import demo.modelo.control.IAutoresLogic;
import demo.modelo.control.IEpocaLogic;
import demo.modelo.control.IGeneroLogic;
import demo.modelo.control.IObrasLogic;
import demo.modelo.control.ObrasLogic;

import demo.modelo.dto.AutoresDTO;
import demo.modelo.dto.EpocaDTO;
import demo.modelo.dto.GeneroDTO;
import demo.modelo.dto.ObrasDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Autores> getAutores() throws Exception;

    public void saveAutores(Autores entity) throws Exception;

    public void deleteAutores(Autores entity) throws Exception;

    public void updateAutores(Autores entity) throws Exception;

    public Autores getAutores(Integer idautor) throws Exception;

    public List<Autores> findByCriteriaInAutores(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Autores> findPageAutores(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAutores() throws Exception;

    public List<AutoresDTO> getDataAutores() throws Exception;

    public void validateAutores(Autores autores) throws Exception;

    public List<Epoca> getEpoca() throws Exception;

    public void saveEpoca(Epoca entity) throws Exception;

    public void deleteEpoca(Epoca entity) throws Exception;

    public void updateEpoca(Epoca entity) throws Exception;

    public Epoca getEpoca(Integer idepoca) throws Exception;

    public List<Epoca> findByCriteriaInEpoca(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Epoca> findPageEpoca(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEpoca() throws Exception;

    public List<EpocaDTO> getDataEpoca() throws Exception;

    public void validateEpoca(Epoca epoca) throws Exception;

    public List<Genero> getGenero() throws Exception;

    public void saveGenero(Genero entity) throws Exception;

    public void deleteGenero(Genero entity) throws Exception;

    public void updateGenero(Genero entity) throws Exception;

    public Genero getGenero(Integer idgenero) throws Exception;

    public List<Genero> findByCriteriaInGenero(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Genero> findPageGenero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGenero() throws Exception;

    public List<GeneroDTO> getDataGenero() throws Exception;

    public void validateGenero(Genero genero) throws Exception;

    public List<Obras> getObras() throws Exception;

    public void saveObras(Obras entity) throws Exception;

    public void deleteObras(Obras entity) throws Exception;

    public void updateObras(Obras entity) throws Exception;

    public Obras getObras(Integer idobra) throws Exception;

    public List<Obras> findByCriteriaInObras(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Obras> findPageObras(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberObras() throws Exception;

    public List<ObrasDTO> getDataObras() throws Exception;

    public void validateObras(Obras obras) throws Exception;
}
