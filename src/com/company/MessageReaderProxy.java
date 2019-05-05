package com.company;

import java.util.ArrayList;

class MessageReaderProxy implements MessageReaderAPI {

    private MessageReader messageReader;
    private String token;

    MessageReaderProxy(String token) {
        this.token = token;
        messageReader = new MessageReader();
    }

    /**
     * Method check if current user can read messages by id (User can read only his messages)
     *
     * @param id id of user
     */
    @Override
    public ArrayList<String> getMessagesByUserID(Integer id) {
        if (LoginService.getInstance().isTokenCanReadID(token, id)) {
            return messageReader.getMessagesByUserID(id);
        } else {
            return null;
        }

    }
}
