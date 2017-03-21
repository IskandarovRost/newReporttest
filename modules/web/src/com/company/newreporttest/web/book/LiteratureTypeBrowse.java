package com.company.newreporttest.web.book;

import com.company.newreporttest.entity.LiteratureType;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class LiteratureTypeBrowse extends AbstractLookup {

    /**
     * The {@link CollectionDatasource} instance that loads a list of {@link LiteratureType} records
     * to be displayed in {@link LiteratureTypeBrowse#literatureTypesTable} on the left
     */
    @Inject
    private CollectionDatasource<LiteratureType, UUID> literatureTypesDs;

    /**
     * The {@link Datasource} instance that contains an instance of the selected entity
     * in {@link LiteratureTypeBrowse#literatureTypesDs}
     * <p/> Containing instance is loaded in {@link CollectionDatasource#addItemChangeListener}
     * with the view, specified in the XML screen descriptor.
     * The listener is set in the {@link LiteratureTypeBrowse#init(Map)} method
     */
    @Inject
    private Datasource<LiteratureType> literatureTypeDs;

    /**
     * The {@link Table} instance, containing a list of {@link LiteratureType} records,
     * loaded via {@link LiteratureTypeBrowse#literatureTypesDs}
     */
    @Inject
    private Table<LiteratureType> literatureTypesTable;

    /**
     * The {@link BoxLayout} instance that contains components on the left side
     * of {@link SplitPanel}
     */
    @Inject
    private BoxLayout lookupBox;

    /**
     * The {@link BoxLayout} instance that contains buttons to invoke Save or Cancel actions in edit mode
     */
    @Inject
    private BoxLayout actionsPane;

    /**
     * The {@link FieldGroup} instance that is linked to {@link LiteratureTypeBrowse#literatureTypeDs}
     * and shows fields of the selected {@link LiteratureType} record
     */
    @Inject
    private FieldGroup fieldGroup;

    /**
     * The {@link RemoveAction} instance, related to {@link LiteratureTypeBrowse#literatureTypesTable}
     */
    @Named("literatureTypesTable.remove")
    private RemoveAction literatureTypesTableRemove;

    @Inject
    private DataSupplier dataSupplier;

    /**
     * {@link Boolean} value, indicating if a new instance of {@link LiteratureType} is being created
     */
    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {

        /*
         * Adding {@link com.haulmont.cuba.gui.data.Datasource.ItemChangeListener} to {@link literatureTypesDs}
         * The listener reloads the selected record with the specified view and sets it to {@link literatureTypeDs}
         */
        literatureTypesDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                LiteratureType reloadedItem = dataSupplier.reload(e.getDs().getItem(), literatureTypeDs.getView());
                literatureTypeDs.setItem(reloadedItem);
            }
        });

        /*
         * Adding {@link CreateAction} to {@link literatureTypesTable}
         * The listener removes selection in {@link literatureTypesTable}, sets a newly created item to {@link literatureTypeDs}
         * and enables controls for record editing
         */
        literatureTypesTable.addAction(new CreateAction(literatureTypesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                literatureTypesTable.setSelected(Collections.emptyList());
                literatureTypeDs.setItem((LiteratureType) newItem);
                refreshOptionsForLookupFields();
                enableEditControls(true);
            }
        });

        /*
         * Adding {@link EditAction} to {@link literatureTypesTable}
         * The listener enables controls for record editing
         */
        literatureTypesTable.addAction(new EditAction(literatureTypesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (literatureTypesTable.getSelected().size() == 1) {
                    refreshOptionsForLookupFields();
                    enableEditControls(false);
                }
            }
        });

        /*
         * Setting {@link RemoveAction#afterRemoveHandler} for {@link literatureTypesTableRemove}
         * to reset record, contained in {@link literatureTypeDs}
         */
        literatureTypesTableRemove.setAfterRemoveHandler(removedItems -> literatureTypeDs.setItem(null));

        disableEditControls();
    }

    private void refreshOptionsForLookupFields() {
        for (Component component : fieldGroup.getOwnComponents()) {
            if (component instanceof LookupField) {
                CollectionDatasource optionsDatasource = ((LookupField) component).getOptionsDatasource();
                if (optionsDatasource != null) {
                    optionsDatasource.refresh();
                }
            }
        }
    }

    /**
     * Method that is invoked by clicking Ok button after editing an existing or creating a new record
     */
    public void save() {
        if (!validate(Collections.singletonList(fieldGroup))) {
            return;
        }
        getDsContext().commit();

        LiteratureType editedItem = literatureTypeDs.getItem();
        if (creating) {
            literatureTypesDs.includeItem(editedItem);
        } else {
            literatureTypesDs.updateItem(editedItem);
        }
        literatureTypesTable.setSelected(editedItem);

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Cancel button, discards changes and disables controls for record editing
     */
    public void cancel() {
        LiteratureType selectedItem = literatureTypesDs.getItem();
        if (selectedItem != null) {
            LiteratureType reloadedItem = dataSupplier.reload(selectedItem, literatureTypeDs.getView());
            literatureTypesDs.setItem(reloadedItem);
        } else {
            literatureTypeDs.setItem(null);
        }

        disableEditControls();
    }

    /**
     * Enabling controls for record editing
     * @param creating indicates if a new instance of {@link LiteratureType} is being created
     */
    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        fieldGroup.requestFocus();
    }

    /**
     * Disabling editing controls
     */
    private void disableEditControls() {
        initEditComponents(false);
        literatureTypesTable.requestFocus();
    }

    /**
     * Initiating edit controls, depending on if they should be enabled/disabled
     * @param enabled if true - enables editing controls and disables controls on the left side of the splitter
     *                if false - visa versa
     */
    private void initEditComponents(boolean enabled) {
        fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}