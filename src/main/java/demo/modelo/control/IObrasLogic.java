package demo.modelo.control;

import demo.modelo.Obras;

import demo.modelo.dto.ObrasDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IObrasLogic {
    public List<Obras> getObras() throws Exception;

    /**
         * Save an new Obras entity
         */
    public void saveObras(Obras entity) throws Exception;

    /**
         * Delete an existing Obras entity
         *
         */
    public void deleteObras(Obras entity) throws Exception;

    /**
        * Update an existing Obras entity
        *
        */
    public void updateObras(Obras entity) throws Exception;

    /**
         * Load an existing Obras entity
         *
         */
    public Obras getObras(Integer idobra) throws Exception;

    public List<Obras> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Obras> findPageObras(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberObras() throws Exception;

    public List<ObrasDTO> getDataObras() throws Exception;

    public void validateObras(Obras obras) throws Exception;
}
