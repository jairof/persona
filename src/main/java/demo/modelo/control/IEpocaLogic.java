package demo.modelo.control;

import demo.modelo.Epoca;

import demo.modelo.dto.EpocaDTO;

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
public interface IEpocaLogic {
    public List<Epoca> getEpoca() throws Exception;

    /**
         * Save an new Epoca entity
         */
    public void saveEpoca(Epoca entity) throws Exception;

    /**
         * Delete an existing Epoca entity
         *
         */
    public void deleteEpoca(Epoca entity) throws Exception;

    /**
        * Update an existing Epoca entity
        *
        */
    public void updateEpoca(Epoca entity) throws Exception;

    /**
         * Load an existing Epoca entity
         *
         */
    public Epoca getEpoca(Integer idepoca) throws Exception;

    public List<Epoca> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Epoca> findPageEpoca(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEpoca() throws Exception;

    public List<EpocaDTO> getDataEpoca() throws Exception;

    public void validateEpoca(Epoca epoca) throws Exception;
}
