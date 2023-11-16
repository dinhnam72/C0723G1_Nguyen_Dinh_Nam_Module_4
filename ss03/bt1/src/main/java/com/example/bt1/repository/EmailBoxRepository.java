package com.example.bt1.repository;

import com.example.bt1.model.EmailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    private static List<EmailBox> emailBoxList = new ArrayList<>();

    static {
        emailBoxList.add(new EmailBox(1, "English", 5, true, "Thuy"));
        emailBoxList.add(new EmailBox(2, "Vietnamese", 25, false, "Lieu"));
        emailBoxList.add(new EmailBox(3, "Japanese", 50, false, "Dao"));
        emailBoxList.add(new EmailBox(4, "Chinese", 100, true, "Sanji"));
    }

    @Override
    public List<EmailBox> display() {
        return emailBoxList;
    }

    @Override
    public EmailBox checkById(int id) {
        for (EmailBox emailBox : emailBoxList) {
            if (emailBox.getId() == id) {
                return emailBox;
            }
        }
        return null;
    }

    @Override
    public void update(EmailBox emailBox) {
        for (int i = 0; i < emailBoxList.size(); i++) {
            if (emailBoxList.get(i).getId() == emailBox.getId()) {
                emailBoxList.set(i, emailBox);
            }
        }
    }
}
