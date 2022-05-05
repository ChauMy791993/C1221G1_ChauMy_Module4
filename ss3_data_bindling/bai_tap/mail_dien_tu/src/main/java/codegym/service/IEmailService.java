package codegym.service;

import codegym.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> getList();
    void save (Email email);
}
