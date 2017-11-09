package demo.presentation.backingBeans;

import demo.exceptions.*;

import demo.modelo.*;

import demo.modelo.dto.ObrasDTO;

import demo.presentation.businessDelegate.*;

import demo.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ObrasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ObrasView.class);
    private InputText txtAno;
    private InputText txtArgumento;
    private InputText txtCritica;
    private InputText txtTitulo;
    private InputText txtIdautor_Autores;
    private InputText txtIdepoca_Epoca;
    private InputText txtIdgenero_Genero;
    private InputText txtIdobra;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ObrasDTO> data;
    private ObrasDTO selectedObras;
    private Obras entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ObrasView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedObras = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedObras = null;

        if (txtAno != null) {
            txtAno.setValue(null);
            txtAno.setDisabled(true);
        }

        if (txtArgumento != null) {
            txtArgumento.setValue(null);
            txtArgumento.setDisabled(true);
        }

        if (txtCritica != null) {
            txtCritica.setValue(null);
            txtCritica.setDisabled(true);
        }

        if (txtTitulo != null) {
            txtTitulo.setValue(null);
            txtTitulo.setDisabled(true);
        }

        if (txtIdautor_Autores != null) {
            txtIdautor_Autores.setValue(null);
            txtIdautor_Autores.setDisabled(true);
        }

        if (txtIdepoca_Epoca != null) {
            txtIdepoca_Epoca.setValue(null);
            txtIdepoca_Epoca.setDisabled(true);
        }

        if (txtIdgenero_Genero != null) {
            txtIdgenero_Genero.setValue(null);
            txtIdgenero_Genero.setDisabled(true);
        }

        if (txtIdobra != null) {
            txtIdobra.setValue(null);
            txtIdobra.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer idobra = FacesUtils.checkInteger(txtIdobra);
            entity = (idobra != null) ? businessDelegatorView.getObras(idobra)
                                      : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAno.setDisabled(false);
            txtArgumento.setDisabled(false);
            txtCritica.setDisabled(false);
            txtTitulo.setDisabled(false);
            txtIdautor_Autores.setDisabled(false);
            txtIdepoca_Epoca.setDisabled(false);
            txtIdgenero_Genero.setDisabled(false);
            txtIdobra.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAno.setValue(entity.getAno());
            txtAno.setDisabled(false);
            txtArgumento.setValue(entity.getArgumento());
            txtArgumento.setDisabled(false);
            txtCritica.setValue(entity.getCritica());
            txtCritica.setDisabled(false);
            txtTitulo.setValue(entity.getTitulo());
            txtTitulo.setDisabled(false);
            txtIdautor_Autores.setValue(entity.getAutores().getIdautor());
            txtIdautor_Autores.setDisabled(false);
            txtIdepoca_Epoca.setValue(entity.getEpoca().getIdepoca());
            txtIdepoca_Epoca.setDisabled(false);
            txtIdgenero_Genero.setValue(entity.getGenero().getIdgenero());
            txtIdgenero_Genero.setDisabled(false);
            txtIdobra.setValue(entity.getIdobra());
            txtIdobra.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedObras = (ObrasDTO) (evt.getComponent().getAttributes()
                                       .get("selectedObras"));
        txtAno.setValue(selectedObras.getAno());
        txtAno.setDisabled(false);
        txtArgumento.setValue(selectedObras.getArgumento());
        txtArgumento.setDisabled(false);
        txtCritica.setValue(selectedObras.getCritica());
        txtCritica.setDisabled(false);
        txtTitulo.setValue(selectedObras.getTitulo());
        txtTitulo.setDisabled(false);
        txtIdautor_Autores.setValue(selectedObras.getIdautor_Autores());
        txtIdautor_Autores.setDisabled(false);
        txtIdepoca_Epoca.setValue(selectedObras.getIdepoca_Epoca());
        txtIdepoca_Epoca.setDisabled(false);
        txtIdgenero_Genero.setValue(selectedObras.getIdgenero_Genero());
        txtIdgenero_Genero.setDisabled(false);
        txtIdobra.setValue(selectedObras.getIdobra());
        txtIdobra.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedObras == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Obras();

            Integer idobra = FacesUtils.checkInteger(txtIdobra);

            entity.setAno(FacesUtils.checkInteger(txtAno));
            entity.setArgumento(FacesUtils.checkString(txtArgumento));
            entity.setCritica(FacesUtils.checkString(txtCritica));
            entity.setIdobra(idobra);
            entity.setTitulo(FacesUtils.checkString(txtTitulo));
            entity.setAutores((FacesUtils.checkInteger(txtIdautor_Autores) != null)
                ? businessDelegatorView.getAutores(FacesUtils.checkInteger(
                        txtIdautor_Autores)) : null);
            entity.setEpoca((FacesUtils.checkInteger(txtIdepoca_Epoca) != null)
                ? businessDelegatorView.getEpoca(FacesUtils.checkInteger(
                        txtIdepoca_Epoca)) : null);
            entity.setGenero((FacesUtils.checkInteger(txtIdgenero_Genero) != null)
                ? businessDelegatorView.getGenero(FacesUtils.checkInteger(
                        txtIdgenero_Genero)) : null);
            businessDelegatorView.saveObras(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer idobra = new Integer(selectedObras.getIdobra());
                entity = businessDelegatorView.getObras(idobra);
            }

            entity.setAno(FacesUtils.checkInteger(txtAno));
            entity.setArgumento(FacesUtils.checkString(txtArgumento));
            entity.setCritica(FacesUtils.checkString(txtCritica));
            entity.setTitulo(FacesUtils.checkString(txtTitulo));
            entity.setAutores((FacesUtils.checkInteger(txtIdautor_Autores) != null)
                ? businessDelegatorView.getAutores(FacesUtils.checkInteger(
                        txtIdautor_Autores)) : null);
            entity.setEpoca((FacesUtils.checkInteger(txtIdepoca_Epoca) != null)
                ? businessDelegatorView.getEpoca(FacesUtils.checkInteger(
                        txtIdepoca_Epoca)) : null);
            entity.setGenero((FacesUtils.checkInteger(txtIdgenero_Genero) != null)
                ? businessDelegatorView.getGenero(FacesUtils.checkInteger(
                        txtIdgenero_Genero)) : null);
            businessDelegatorView.updateObras(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedObras = (ObrasDTO) (evt.getComponent().getAttributes()
                                           .get("selectedObras"));

            Integer idobra = new Integer(selectedObras.getIdobra());
            entity = businessDelegatorView.getObras(idobra);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idobra = FacesUtils.checkInteger(txtIdobra);
            entity = businessDelegatorView.getObras(idobra);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteObras(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(Integer ano, String argumento,
        String critica, Integer idobra, String titulo, Integer idautor_Autores,
        Integer idepoca_Epoca, Integer idgenero_Genero)
        throws Exception {
        try {
            entity.setAno(FacesUtils.checkInteger(ano));
            entity.setArgumento(FacesUtils.checkString(argumento));
            entity.setCritica(FacesUtils.checkString(critica));
            entity.setTitulo(FacesUtils.checkString(titulo));
            businessDelegatorView.updateObras(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ObrasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAno() {
        return txtAno;
    }

    public void setTxtAno(InputText txtAno) {
        this.txtAno = txtAno;
    }

    public InputText getTxtArgumento() {
        return txtArgumento;
    }

    public void setTxtArgumento(InputText txtArgumento) {
        this.txtArgumento = txtArgumento;
    }

    public InputText getTxtCritica() {
        return txtCritica;
    }

    public void setTxtCritica(InputText txtCritica) {
        this.txtCritica = txtCritica;
    }

    public InputText getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(InputText txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public InputText getTxtIdautor_Autores() {
        return txtIdautor_Autores;
    }

    public void setTxtIdautor_Autores(InputText txtIdautor_Autores) {
        this.txtIdautor_Autores = txtIdautor_Autores;
    }

    public InputText getTxtIdepoca_Epoca() {
        return txtIdepoca_Epoca;
    }

    public void setTxtIdepoca_Epoca(InputText txtIdepoca_Epoca) {
        this.txtIdepoca_Epoca = txtIdepoca_Epoca;
    }

    public InputText getTxtIdgenero_Genero() {
        return txtIdgenero_Genero;
    }

    public void setTxtIdgenero_Genero(InputText txtIdgenero_Genero) {
        this.txtIdgenero_Genero = txtIdgenero_Genero;
    }

    public InputText getTxtIdobra() {
        return txtIdobra;
    }

    public void setTxtIdobra(InputText txtIdobra) {
        this.txtIdobra = txtIdobra;
    }

    public List<ObrasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataObras();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ObrasDTO> obrasDTO) {
        this.data = obrasDTO;
    }

    public ObrasDTO getSelectedObras() {
        return selectedObras;
    }

    public void setSelectedObras(ObrasDTO obras) {
        this.selectedObras = obras;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
