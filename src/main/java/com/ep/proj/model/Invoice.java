package com.ep.proj.model;

public class Invoice extends BaseEntity{
    private Project project;
    private Integer invoicePrice;
    private User Client;
    private User Manager;

    public Invoice(Integer id, String name, Project project, Integer invoicePrice, User client, User manager) {
        super(id, name);
        this.project = project;
        this.invoicePrice = invoicePrice;
        Client = client;
        Manager = manager;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Integer invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public User getClient() {
        return Client;
    }

    public void setClient(User client) {
        Client = client;
    }

    public User getManager() {
        return Manager;
    }

    public void setManager(User manager) {
        Manager = manager;
    }
}
