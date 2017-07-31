package com.ep.proj.repository;

import com.ep.proj.model.Invoice;
import java.util.List;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);

    boolean delete(int id);

    Invoice get(int id);

    List<Invoice> getAll();
}
