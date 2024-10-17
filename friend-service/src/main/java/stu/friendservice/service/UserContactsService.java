package stu.friendservice.service;

import stu.friendservice.entity.UserContacts;

public interface UserContactsService {

    UserContacts getContactById(Integer id);

    UserContacts getContactsByUserId(Integer user_id);

    boolean createContact(UserContacts userContacts);

    boolean updateContact(UserContacts userContacts);

    boolean deleteContact(Integer id);
}
