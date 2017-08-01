package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Invoice;
import com.ep.proj.repository.InvoiceRepository;
import com.ep.proj.repository.mock.InMemoryInvoiceRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class InvoiceControllerImpl implements Controller{
    private final InvoiceRepository repository;
    private static final Logger log = getLogger(InvoiceRepository.class);

    public InvoiceControllerImpl() {
        this.repository = new InMemoryInvoiceRepository();
    }

    public InvoiceControllerImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Invoice> getAll()  throws NotFoundException {
        log.debug("GET ALL INVOICE");

        List<Invoice> invoices = repository.getAll();
        if (invoices == null) {
            throw new NotFoundException("Error getting invoices");
        } else {
            return invoices;
        }
    }

    @Override
    public Invoice get(int id) throws NotFoundException {
        log.debug("GET INVOICE BY ID");

        Invoice returnInvoice = repository.get(id);
        if (returnInvoice == null) {
            throw new NotFoundException("Error getting invoice");
        } else {
            return returnInvoice;
        }
    }

    @Override
    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE INVOICE BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("Invoice id not found");
        } else {
            return true;
        }
    }

    @Override
    public Invoice update(BaseEntity invoice, int id) throws NotFoundException {
        log.debug("UPDATE INVOICE BY ID");
        Invoice returnedInvoice;
        if (invoice.getId() == id){
            returnedInvoice = repository.save((Invoice) invoice);
        } else {
            throw new NotFoundException("Invoice id incorrect");
        }
        if (returnedInvoice == null) {
            throw new NotFoundException("Invoice id incorrect");
        } else {
            return returnedInvoice;
        }
    }

    @Override
    public Invoice create(BaseEntity invoice) throws NotFoundException {
        log.debug("CREATE INVOICE");

        Invoice returnInvoice = repository.save((Invoice) invoice);
        if (returnInvoice == null) {
            throw new NotFoundException("Error creation invoice");
        } else {
            return returnInvoice;
        }
    }
}