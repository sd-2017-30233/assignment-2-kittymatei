package data;

import java.io.Serializable;

/**
 * Created by Cristina on 4/12/2017.
 */
public abstract class User implements Serializable{
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username=username;
        this.password=password;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    public abstract boolean logIn();

}
