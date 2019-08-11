package com.jason.jason_ssm.controller;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateEdit extends PropertiesEditor {

    private String datefmt;

    public MyDateEdit(String datefmt) {
        this.datefmt = datefmt;
    }

    @Override
    public void setAsText(String source) throws IllegalArgumentException {
        SimpleDateFormat sdf = getDateFromte(source);
        try {
            Date date = sdf.parse(source);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAsText() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datefmt);
        return simpleDateFormat.format(this.getValue());
    }

    private SimpleDateFormat getDateFromte(String source) {

        SimpleDateFormat sdf = new SimpleDateFormat(datefmt);

        return sdf;
    }
}
