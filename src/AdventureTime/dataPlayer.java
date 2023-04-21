package AdventureTime;

import java.util.Arrays;

public class dataPlayer {
    private String username;
    private int age;
    private String password;

    public dataPlayer(String username, int age, char[] password) {
        this.username = username;
        this.age = age;
        this.password = new String(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
