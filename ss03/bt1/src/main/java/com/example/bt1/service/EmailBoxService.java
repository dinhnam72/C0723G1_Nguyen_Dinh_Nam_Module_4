package com.example.bt1.service;

import com.example.bt1.model.EmailBox;
import com.example.bt1.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    private IEmailBoxRepository emailBoxRepository;

    @Override
    public List<EmailBox> display() {
        return emailBoxRepository.display();
    }

    @Override
    public EmailBox checkById(int id) {
        return emailBoxRepository.checkById(id);
    }

    @Override
    public void update(EmailBox emailBox) {
        emailBoxRepository.update(emailBox);
    }
}
