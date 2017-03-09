package com.company.newreporttest.web.book;

import com.company.newreporttest.entity.Book;
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

public class BookBrowse extends AbstractLookup {

    /**
     * The {@link CollectionDatasource} instance that loads a list of {@link Book} records
     * to be displayed in {@link BookBrowse#booksTable} on the left
     */
    @Inject
    private CollectionDatasource<Book, UUID> booksDs;

    /**
     * The {@link Datasource} instance that contains an instance of the selected entity
     * in {@link BookBrowse#booksDs}
     * <p/> Containing instance is loaded in {@link CollectionDatasource#addItemChangeListener}
     * with the view, specified in the XML screen descriptor.
     * The listener is set in the {@link BookBrowse#init(Map)} method
     */
    @Inject
    private Datasource<Book> bookDs;

    /**
     * The {@link Table} instance, containing a list of {@link Book} records,
     * loaded via {@link BookBrowse#booksDs}
     */
    @Inject
    private Table<Book> booksTable;

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
     * The {@link FieldGroup} instance that is linked to {@link BookBrowse#bookDs}
     * and shows fields of the selected {@link Book} record
     */
    @Inject
    private FieldGroup fieldGroup;

    /**
     * The {@link RemoveAction} instance, related to {@link BookBrowse#booksTable}
     */
    @Named("booksTable.remove")
    private RemoveAction booksTableRemove;

    @Inject
    private DataSupplier dataSupplier;

    /**
     * {@link Boolean} value, indicating if a new instance of {@link Book} is being created
     */
    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {

        /*
         * Adding {@link com.haulmont.cuba.gui.data.Datasource.ItemChangeListener} to {@link booksDs}
         * The listener reloads the selected record with the specified view and sets it to {@link bookDs}
         */
        booksDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Book reloadedItem = dataSupplier.reload(e.getDs().getItem(), bookDs.getView());
                bookDs.setItem(reloadedItem);
            }
        });

        /*
         * Adding {@link CreateAction} to {@link booksTable}
         * The listener removes selection in {@link booksTable}, sets a newly created item to {@link bookDs}
         * and enables controls for record editing
         */
        booksTable.addAction(new CreateAction(booksTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                booksTable.setSelected(Collections.emptyList());
                bookDs.setItem((Book) newItem);
                refreshOptionsForLookupFields();
                enableEditControls(true);
            }
        });

        /*
         * Adding {@link EditAction} to {@link booksTable}
         * The listener enables controls for record editing
         */
        booksTable.addAction(new EditAction(booksTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (booksTable.getSelected().size() == 1) {
                    refreshOptionsForLookupFields();
                    enableEditControls(false);
                }
            }
        });

        /*
         * Setting {@link RemoveAction#afterRemoveHandler} for {@link booksTableRemove}
         * to reset record, contained in {@link bookDs}
         */
        booksTableRemove.setAfterRemoveHandler(removedItems -> bookDs.setItem(null));

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

        Book editedItem = bookDs.getItem();
        if (creating) {
            booksDs.includeItem(editedItem);
        } else {
            booksDs.updateItem(editedItem);
        }
        booksTable.setSelected(editedItem);

        disableEditControls();
    }

    /**
     * Method that is invoked by clicking Cancel button, discards changes and disables controls for record editing
     */
    public void cancel() {
        Book selectedItem = booksDs.getItem();
        if (selectedItem != null) {
            Book reloadedItem = dataSupplier.reload(selectedItem, bookDs.getView());
            booksDs.setItem(reloadedItem);
        } else {
            bookDs.setItem(null);
        }

        disableEditControls();
    }

    /**
     * Enabling controls for record editing
     * @param creating indicates if a new instance of {@link Book} is being created
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
        booksTable.requestFocus();
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