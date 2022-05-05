package codegym.repository;

import codegym.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> getList();
    void save (Email email);
}
