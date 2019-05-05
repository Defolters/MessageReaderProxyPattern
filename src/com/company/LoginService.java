package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;

public class LoginService {
    private static final LoginService loginService = new LoginService();
    private ArrayList<User> users = new ArrayList<>();

    private LoginService() {
        String resourceName = "users.json";
        InputStream is = MessageReader.class.getResourceAsStream(resourceName);

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        JSONArray jsonUsers = object.getJSONArray("users");

        for (int i = 0; i < jsonUsers.length(); i++) {
            JSONObject jsonUser = jsonUsers.getJSONObject(i);

            String name = jsonUser.getString("name");
            String password = jsonUser.getString("password");
            String token = jsonUser.getString("token");
            Integer id = jsonUser.getInt("id");

            users.add(new User(name, password, id, token));
        }
    }

    public String login(String name, String password) {
        for (User user : users) {
            if ((user.getName().equals(name)) && (user.getPassword().equals(password))) {
                return user.getToken();
            }
        }
        return null;
    }

    public boolean isTokenCanReadID(String token, Integer id) {
        for (User user : users) {
            if ((user.getToken().equals(token)) && (user.getId().equals(id))) {
                return true;
            }
        }
        return false;
    }

    public static LoginService getInstance() {
        return loginService;
    }
}
