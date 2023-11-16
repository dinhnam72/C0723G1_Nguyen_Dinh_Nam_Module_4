package com.example.bt1.service;

import com.example.bt1.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {
    List<EmailBox> display();
    EmailBox checkById(int id);
    void update(EmailBox emailBox);
}
