package com.company.newreporttest.web.author;

import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.RichTextArea;
import com.haulmont.cuba.gui.components.SourceCodeEditor;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import java.util.Map;

public class Screen extends AbstractWindow {


    @Inject
    private SourceCodeEditor sourceCodeEditor;

    @Inject
    private SourceCodeEditor sourceCodeEditor_1;

    @Inject
    private TextField textField;

    @Inject
    private TextField textField_1;

    @Inject
    private TextField textField_2;

    @Inject
    private RichTextArea richTextArea;

    @Override
    public void init(Map<String, Object> params) {
        sourceCodeEditor.addValueChangeListener(e-> showNotification("changedONe"));
        sourceCodeEditor_1.addValueChangeListener(e-> showNotification("changedtwo"));
        textField.addTextChangeListener(e-> showNotification("changedone"));
        textField_1.addTextChangeListener(e-> showNotification("changedtwo"));
        textField_2.addTextChangeListener(e-> showNotification("changedthree"));





        super.init(params);
    }
}