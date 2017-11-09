package demo.presentation.backingBeans;

import demo.exceptions.*;

import demo.modelo.*;

import demo.modelo.dto.GeneroDTO;

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
public class GeneroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GeneroView.class);
    private InputText txtGenero;
    private InputText txtIdgenero;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GeneroDTO> data;
    private GeneroDTO selectedGenero;
    private Genero entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GeneroView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGenero = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGenero = null;

        if (txtGenero != null) {
            txtGenero.setValue(null);
            txtGenero.setDisabled(true);
        }

        if (txtIdgenero != null) {
            txtIdgenero.setValue(null);
            txtIdgenero.setDisabled(false);
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
            Integer idgenero = FacesUtils.checkInteger(txtIdgenero);
            entity = (idgenero != null)
                ? businessDelegatorView.getGenero(idgenero) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtGenero.setDisabled(false);
            txtIdgenero.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtGenero.setValue(entity.getGenero());
            txtGenero.setDisabled(false);
            txtIdgenero.setValue(entity.getIdgenero());
            txtIdgenero.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGenero = (GeneroDTO) (evt.getComponent().getAttributes()
                                         .get("selectedGenero"));
        txtGenero.setValue(selectedGenero.getGenero());
        txtGenero.setDisabled(false);
        txtIdgenero.setValue(selectedGenero.getIdgenero());
        txtIdgenero.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGenero == null) && (entity == null)) {
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
            entity = new Genero();

            Integer idgenero = FacesUtils.checkInteger(txtIdgenero);

            entity.setGenero(FacesUtils.checkString(txtGenero));
            entity.setIdgenero(idgenero);
            businessDelegatorView.saveGenero(entity);
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
                Integer idgenero = new Integer(selectedGenero.getIdgenero());
                entity = businessDelegatorView.getGenero(idgenero);
            }

            entity.setGenero(FacesUtils.checkString(txtGenero));
            businessDelegatorView.updateGenero(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGenero = (GeneroDTO) (evt.getComponent().getAttributes()
                                             .get("selectedGenero"));

            Integer idgenero = new Integer(selectedGenero.getIdgenero());
            entity = businessDelegatorView.getGenero(idgenero);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idgenero = FacesUtils.checkInteger(txtIdgenero);
            entity = businessDelegatorView.getGenero(idgenero);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGenero(entity);
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

    public String action_modifyWitDTO(String genero, Integer idgenero)
        throws Exception {
        try {
            entity.setGenero(FacesUtils.checkString(genero));
            businessDelegatorView.updateGenero(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GeneroView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(InputText txtGenero) {
        this.txtGenero = txtGenero;
    }

    public InputText getTxtIdgenero() {
        return txtIdgenero;
    }

    public void setTxtIdgenero(InputText txtIdgenero) {
        this.txtIdgenero = txtIdgenero;
    }

    public List<GeneroDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGenero();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GeneroDTO> generoDTO) {
        this.data = generoDTO;
    }

    public GeneroDTO getSelectedGenero() {
        return selectedGenero;
    }

    public void setSelectedGenero(GeneroDTO genero) {
        this.selectedGenero = genero;
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
