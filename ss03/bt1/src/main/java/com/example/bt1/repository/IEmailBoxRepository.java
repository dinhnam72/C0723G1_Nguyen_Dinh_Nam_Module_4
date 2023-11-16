package com.example.bt1.repository;

import com.example.bt1.model.EmailBox;

import java.util.List;

public interface IEmailBoxRepository {
    List<EmailBox> display();
    EmailBox checkById(int id);
    void update(EmailBox emailBox);
}
