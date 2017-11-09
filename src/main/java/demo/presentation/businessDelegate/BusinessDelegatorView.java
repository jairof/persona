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

import demo.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IAutoresLogic autoresLogic;
    @Autowired
    private IEpocaLogic epocaLogic;
    @Autowired
    private IGeneroLogic generoLogic;
    @Autowired
    private IObrasLogic obrasLogic;

    public List<Autores> getAutores() throws Exception {
        return autoresLogic.getAutores();
    }

    public void saveAutores(Autores entity) throws Exception {
        autoresLogic.saveAutores(entity);
    }

    public void deleteAutores(Autores entity) throws Exception {
        autoresLogic.deleteAutores(entity);
    }

    public void updateAutores(Autores entity) throws Exception {
        autoresLogic.updateAutores(entity);
    }

    public Autores getAutores(Integer idautor) throws Exception {
        Autores autores = null;

        try {
            autores = autoresLogic.getAutores(idautor);
        } catch (Exception e) {
            throw e;
        }

        return autores;
    }

    public List<Autores> findByCriteriaInAutores(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return autoresLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Autores> findPageAutores(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return autoresLogic.findPageAutores(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberAutores() throws Exception {
        return autoresLogic.findTotalNumberAutores();
    }

    public List<AutoresDTO> getDataAutores() throws Exception {
        return autoresLogic.getDataAutores();
    }

    public void validateAutores(Autores autores) throws Exception {
        autoresLogic.validateAutores(autores);
    }

    public List<Epoca> getEpoca() throws Exception {
        return epocaLogic.getEpoca();
    }

    public void saveEpoca(Epoca entity) throws Exception {
        epocaLogic.saveEpoca(entity);
    }

    public void deleteEpoca(Epoca entity) throws Exception {
        epocaLogic.deleteEpoca(entity);
    }

    public void updateEpoca(Epoca entity) throws Exception {
        epocaLogic.updateEpoca(entity);
    }

    public Epoca getEpoca(Integer idepoca) throws Exception {
        Epoca epoca = null;

        try {
            epoca = epocaLogic.getEpoca(idepoca);
        } catch (Exception e) {
            throw e;
        }

        return epoca;
    }

    public List<Epoca> findByCriteriaInEpoca(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return epocaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Epoca> findPageEpoca(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return epocaLogic.findPageEpoca(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEpoca() throws Exception {
        return epocaLogic.findTotalNumberEpoca();
    }

    public List<EpocaDTO> getDataEpoca() throws Exception {
        return epocaLogic.getDataEpoca();
    }

    public void validateEpoca(Epoca epoca) throws Exception {
        epocaLogic.validateEpoca(epoca);
    }

    public List<Genero> getGenero() throws Exception {
        return generoLogic.getGenero();
    }

    public void saveGenero(Genero entity) throws Exception {
        generoLogic.saveGenero(entity);
    }

    public void deleteGenero(Genero entity) throws Exception {
        generoLogic.deleteGenero(entity);
    }

    public void updateGenero(Genero entity) throws Exception {
        generoLogic.updateGenero(entity);
    }

    public Genero getGenero(Integer idgenero) throws Exception {
        Genero genero = null;

        try {
            genero = generoLogic.getGenero(idgenero);
        } catch (Exception e) {
            throw e;
        }

        return genero;
    }

    public List<Genero> findByCriteriaInGenero(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return generoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Genero> findPageGenero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return generoLogic.findPageGenero(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberGenero() throws Exception {
        return generoLogic.findTotalNumberGenero();
    }

    public List<GeneroDTO> getDataGenero() throws Exception {
        return generoLogic.getDataGenero();
    }

    public void validateGenero(Genero genero) throws Exception {
        generoLogic.validateGenero(genero);
    }

    public List<Obras> getObras() throws Exception {
        return obrasLogic.getObras();
    }

    public void saveObras(Obras entity) throws Exception {
        obrasLogic.saveObras(entity);
    }

    public void deleteObras(Obras entity) throws Exception {
        obrasLogic.deleteObras(entity);
    }

    public void updateObras(Obras entity) throws Exception {
        obrasLogic.updateObras(entity);
    }

    public Obras getObras(Integer idobra) throws Exception {
        Obras obras = null;

        try {
            obras = obrasLogic.getObras(idobra);
        } catch (Exception e) {
            throw e;
        }

        return obras;
    }

    public List<Obras> findByCriteriaInObras(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return obrasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Obras> findPageObras(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return obrasLogic.findPageObras(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberObras() throws Exception {
        return obrasLogic.findTotalNumberObras();
    }

    public List<ObrasDTO> getDataObras() throws Exception {
        return obrasLogic.getDataObras();
    }

    public void validateObras(Obras obras) throws Exception {
        obrasLogic.validateObras(obras);
    }
}
