package com.wts.service;

import com.wts.entity.model.Filingcase;

public class FilingcaseService {
    private Filingcase dao = new Filingcase().dao();

    public Filingcase findFirst() {
        return dao.findAll().get(0);
    }
    public void deleteById(int id) {
        dao.deleteById(id);
    }

}

