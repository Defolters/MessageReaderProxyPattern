package com.company;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;

public class MessageReader implements MessageReaderAPI {

    private HashMap<Integer, ArrayList<String>> messages = new HashMap<>();

    // package-private constructor
    MessageReader() {
        String resourceName = "messages.json";
        InputStream is = MessageReader.class.getResourceAsStream(resourceName);

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        JSONArray jsonMessages = object.getJSONArray("messages");

        for (int i = 0; i < jsonMessages.length(); i++) {
            JSONObject message = jsonMessages.getJSONObject(i);
            Integer id = message.getInt("id");

            if (!messages.containsKey(id)) {
                messages.put(id, new ArrayList<>());
            }

            messages.get(id).add(message.getString("message"));
        }
    }

    @Override
    public ArrayList<String> getMessagesByUserID(Integer id) {
        return messages.get(id);
    }

    static MessageReaderAPI getMessageReader(String token) {
        return new MessageReaderProxy(token);
    }
}
