package com.wts.service;

import com.wts.entity.model.Complaintletter;

public class ComplainletterService {
    private Complaintletter dao = new Complaintletter().dao();

    public Complaintletter findFirst() {
        return dao.findAll().get(0);
    }
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Complaintletter findById(int id) {
        return dao.findById(id);
    }
}

