package demo.presentation.backingBeans;

import demo.exceptions.*;

import demo.modelo.*;

import demo.modelo.dto.AutoresDTO;

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
public class AutoresView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AutoresView.class);
    private InputText txtAnofallecimiento;
    private InputText txtAnonacimiento;
    private InputText txtAutor;
    private InputText txtEstilo;
    private InputText txtLugarnaci;
    private InputText txtVida;
    private InputText txtIdepoca_Epoca;
    private InputText txtIdautor;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AutoresDTO> data;
    private AutoresDTO selectedAutores;
    private Autores entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public AutoresView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedAutores = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedAutores = null;

        if (txtAnofallecimiento != null) {
            txtAnofallecimiento.setValue(null);
            txtAnofallecimiento.setDisabled(true);
        }

        if (txtAnonacimiento != null) {
            txtAnonacimiento.setValue(null);
            txtAnonacimiento.setDisabled(true);
        }

        if (txtAutor != null) {
            txtAutor.setValue(null);
            txtAutor.setDisabled(true);
        }

        if (txtEstilo != null) {
            txtEstilo.setValue(null);
            txtEstilo.setDisabled(true);
        }

        if (txtLugarnaci != null) {
            txtLugarnaci.setValue(null);
            txtLugarnaci.setDisabled(true);
        }

        if (txtVida != null) {
            txtVida.setValue(null);
            txtVida.setDisabled(true);
        }

        if (txtIdepoca_Epoca != null) {
            txtIdepoca_Epoca.setValue(null);
            txtIdepoca_Epoca.setDisabled(true);
        }

        if (txtIdautor != null) {
            txtIdautor.setValue(null);
            txtIdautor.setDisabled(false);
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
            Integer idautor = FacesUtils.checkInteger(txtIdautor);
            entity = (idautor != null)
                ? businessDelegatorView.getAutores(idautor) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAnofallecimiento.setDisabled(false);
            txtAnonacimiento.setDisabled(false);
            txtAutor.setDisabled(false);
            txtEstilo.setDisabled(false);
            txtLugarnaci.setDisabled(false);
            txtVida.setDisabled(false);
            txtIdepoca_Epoca.setDisabled(false);
            txtIdautor.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAnofallecimiento.setValue(entity.getAnofallecimiento());
            txtAnofallecimiento.setDisabled(false);
            txtAnonacimiento.setValue(entity.getAnonacimiento());
            txtAnonacimiento.setDisabled(false);
            txtAutor.setValue(entity.getAutor());
            txtAutor.setDisabled(false);
            txtEstilo.setValue(entity.getEstilo());
            txtEstilo.setDisabled(false);
            txtLugarnaci.setValue(entity.getLugarnaci());
            txtLugarnaci.setDisabled(false);
            txtVida.setValue(entity.getVida());
            txtVida.setDisabled(false);
            txtIdepoca_Epoca.setValue(entity.getEpoca().getIdepoca());
            txtIdepoca_Epoca.setDisabled(false);
            txtIdautor.setValue(entity.getIdautor());
            txtIdautor.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedAutores = (AutoresDTO) (evt.getComponent().getAttributes()
                                           .get("selectedAutores"));
        txtAnofallecimiento.setValue(selectedAutores.getAnofallecimiento());
        txtAnofallecimiento.setDisabled(false);
        txtAnonacimiento.setValue(selectedAutores.getAnonacimiento());
        txtAnonacimiento.setDisabled(false);
        txtAutor.setValue(selectedAutores.getAutor());
        txtAutor.setDisabled(false);
        txtEstilo.setValue(selectedAutores.getEstilo());
        txtEstilo.setDisabled(false);
        txtLugarnaci.setValue(selectedAutores.getLugarnaci());
        txtLugarnaci.setDisabled(false);
        txtVida.setValue(selectedAutores.getVida());
        txtVida.setDisabled(false);
        txtIdepoca_Epoca.setValue(selectedAutores.getIdepoca_Epoca());
        txtIdepoca_Epoca.setDisabled(false);
        txtIdautor.setValue(selectedAutores.getIdautor());
        txtIdautor.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedAutores == null) && (entity == null)) {
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
            entity = new Autores();

            Integer idautor = FacesUtils.checkInteger(txtIdautor);

            entity.setAnofallecimiento(FacesUtils.checkInteger(
                    txtAnofallecimiento));
            entity.setAnonacimiento(FacesUtils.checkInteger(txtAnonacimiento));
            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setEstilo(FacesUtils.checkString(txtEstilo));
            entity.setIdautor(idautor);
            entity.setLugarnaci(FacesUtils.checkString(txtLugarnaci));
            entity.setVida(FacesUtils.checkString(txtVida));
            entity.setEpoca((FacesUtils.checkInteger(txtIdepoca_Epoca) != null)
                ? businessDelegatorView.getEpoca(FacesUtils.checkInteger(
                        txtIdepoca_Epoca)) : null);
            businessDelegatorView.saveAutores(entity);
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
                Integer idautor = new Integer(selectedAutores.getIdautor());
                entity = businessDelegatorView.getAutores(idautor);
            }

            entity.setAnofallecimiento(FacesUtils.checkInteger(
                    txtAnofallecimiento));
            entity.setAnonacimiento(FacesUtils.checkInteger(txtAnonacimiento));
            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setEstilo(FacesUtils.checkString(txtEstilo));
            entity.setLugarnaci(FacesUtils.checkString(txtLugarnaci));
            entity.setVida(FacesUtils.checkString(txtVida));
            entity.setEpoca((FacesUtils.checkInteger(txtIdepoca_Epoca) != null)
                ? businessDelegatorView.getEpoca(FacesUtils.checkInteger(
                        txtIdepoca_Epoca)) : null);
            businessDelegatorView.updateAutores(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedAutores = (AutoresDTO) (evt.getComponent().getAttributes()
                                               .get("selectedAutores"));

            Integer idautor = new Integer(selectedAutores.getIdautor());
            entity = businessDelegatorView.getAutores(idautor);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idautor = FacesUtils.checkInteger(txtIdautor);
            entity = businessDelegatorView.getAutores(idautor);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteAutores(entity);
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

    public String action_modifyWitDTO(Integer anofallecimiento,
        Integer anonacimiento, String autor, String estilo, Integer idautor,
        String lugarnaci, String vida, Integer idepoca_Epoca)
        throws Exception {
        try {
            entity.setAnofallecimiento(FacesUtils.checkInteger(anofallecimiento));
            entity.setAnonacimiento(FacesUtils.checkInteger(anonacimiento));
            entity.setAutor(FacesUtils.checkString(autor));
            entity.setEstilo(FacesUtils.checkString(estilo));
            entity.setLugarnaci(FacesUtils.checkString(lugarnaci));
            entity.setVida(FacesUtils.checkString(vida));
            businessDelegatorView.updateAutores(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AutoresView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAnofallecimiento() {
        return txtAnofallecimiento;
    }

    public void setTxtAnofallecimiento(InputText txtAnofallecimiento) {
        this.txtAnofallecimiento = txtAnofallecimiento;
    }

    public InputText getTxtAnonacimiento() {
        return txtAnonacimiento;
    }

    public void setTxtAnonacimiento(InputText txtAnonacimiento) {
        this.txtAnonacimiento = txtAnonacimiento;
    }

    public InputText getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(InputText txtAutor) {
        this.txtAutor = txtAutor;
    }

    public InputText getTxtEstilo() {
        return txtEstilo;
    }

    public void setTxtEstilo(InputText txtEstilo) {
        this.txtEstilo = txtEstilo;
    }

    public InputText getTxtLugarnaci() {
        return txtLugarnaci;
    }

    public void setTxtLugarnaci(InputText txtLugarnaci) {
        this.txtLugarnaci = txtLugarnaci;
    }

    public InputText getTxtVida() {
        return txtVida;
    }

    public void setTxtVida(InputText txtVida) {
        this.txtVida = txtVida;
    }

    public InputText getTxtIdepoca_Epoca() {
        return txtIdepoca_Epoca;
    }

    public void setTxtIdepoca_Epoca(InputText txtIdepoca_Epoca) {
        this.txtIdepoca_Epoca = txtIdepoca_Epoca;
    }

    public InputText getTxtIdautor() {
        return txtIdautor;
    }

    public void setTxtIdautor(InputText txtIdautor) {
        this.txtIdautor = txtIdautor;
    }

    public List<AutoresDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAutores();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<AutoresDTO> autoresDTO) {
        this.data = autoresDTO;
    }

    public AutoresDTO getSelectedAutores() {
        return selectedAutores;
    }

    public void setSelectedAutores(AutoresDTO autores) {
        this.selectedAutores = autores;
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
