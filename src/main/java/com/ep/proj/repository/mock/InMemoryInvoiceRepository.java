package com.ep.proj.repository.mock;

import com.ep.proj.model.Invoice;
import com.ep.proj.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryInvoiceRepository implements InvoiceRepository{
    private Map<Integer, Invoice> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        MockDB.INVOICE_LIST.forEach(this::save);
        counter.set(repository.size());
    }

    @Override
    public Invoice save(Invoice invoice) {
        if (invoice.isNew()) {
            invoice.setId(counter.incrementAndGet());
        }
        repository.put(invoice.getId(), invoice);
        return invoice;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Invoice get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Invoice> getAll() {
        return new ArrayList<>(repository.values());
    }
}