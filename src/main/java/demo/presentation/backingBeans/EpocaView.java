package demo.presentation.backingBeans;

import demo.exceptions.*;

import demo.modelo.*;

import demo.modelo.dto.EpocaDTO;

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
public class EpocaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EpocaView.class);
    private InputText txtEpoca;
    private InputText txtTiempocompren;
    private InputText txtIdepoca;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EpocaDTO> data;
    private EpocaDTO selectedEpoca;
    private Epoca entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EpocaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedEpoca = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEpoca = null;

        if (txtEpoca != null) {
            txtEpoca.setValue(null);
            txtEpoca.setDisabled(true);
        }

        if (txtTiempocompren != null) {
            txtTiempocompren.setValue(null);
            txtTiempocompren.setDisabled(true);
        }

        if (txtIdepoca != null) {
            txtIdepoca.setValue(null);
            txtIdepoca.setDisabled(false);
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
            Integer idepoca = FacesUtils.checkInteger(txtIdepoca);
            entity = (idepoca != null)
                ? businessDelegatorView.getEpoca(idepoca) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEpoca.setDisabled(false);
            txtTiempocompren.setDisabled(false);
            txtIdepoca.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEpoca.setValue(entity.getEpoca());
            txtEpoca.setDisabled(false);
            txtTiempocompren.setValue(entity.getTiempocompren());
            txtTiempocompren.setDisabled(false);
            txtIdepoca.setValue(entity.getIdepoca());
            txtIdepoca.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEpoca = (EpocaDTO) (evt.getComponent().getAttributes()
                                       .get("selectedEpoca"));
        txtEpoca.setValue(selectedEpoca.getEpoca());
        txtEpoca.setDisabled(false);
        txtTiempocompren.setValue(selectedEpoca.getTiempocompren());
        txtTiempocompren.setDisabled(false);
        txtIdepoca.setValue(selectedEpoca.getIdepoca());
        txtIdepoca.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEpoca == null) && (entity == null)) {
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
            entity = new Epoca();

            Integer idepoca = FacesUtils.checkInteger(txtIdepoca);

            entity.setEpoca(FacesUtils.checkString(txtEpoca));
            entity.setIdepoca(idepoca);
            entity.setTiempocompren(FacesUtils.checkString(txtTiempocompren));
            businessDelegatorView.saveEpoca(entity);
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
                Integer idepoca = new Integer(selectedEpoca.getIdepoca());
                entity = businessDelegatorView.getEpoca(idepoca);
            }

            entity.setEpoca(FacesUtils.checkString(txtEpoca));
            entity.setTiempocompren(FacesUtils.checkString(txtTiempocompren));
            businessDelegatorView.updateEpoca(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEpoca = (EpocaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedEpoca"));

            Integer idepoca = new Integer(selectedEpoca.getIdepoca());
            entity = businessDelegatorView.getEpoca(idepoca);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idepoca = FacesUtils.checkInteger(txtIdepoca);
            entity = businessDelegatorView.getEpoca(idepoca);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEpoca(entity);
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

    public String action_modifyWitDTO(String epoca, Integer idepoca,
        String tiempocompren) throws Exception {
        try {
            entity.setEpoca(FacesUtils.checkString(epoca));
            entity.setTiempocompren(FacesUtils.checkString(tiempocompren));
            businessDelegatorView.updateEpoca(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EpocaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEpoca() {
        return txtEpoca;
    }

    public void setTxtEpoca(InputText txtEpoca) {
        this.txtEpoca = txtEpoca;
    }

    public InputText getTxtTiempocompren() {
        return txtTiempocompren;
    }

    public void setTxtTiempocompren(InputText txtTiempocompren) {
        this.txtTiempocompren = txtTiempocompren;
    }

    public InputText getTxtIdepoca() {
        return txtIdepoca;
    }

    public void setTxtIdepoca(InputText txtIdepoca) {
        this.txtIdepoca = txtIdepoca;
    }

    public List<EpocaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEpoca();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EpocaDTO> epocaDTO) {
        this.data = epocaDTO;
    }

    public EpocaDTO getSelectedEpoca() {
        return selectedEpoca;
    }

    public void setSelectedEpoca(EpocaDTO epoca) {
        this.selectedEpoca = epoca;
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
