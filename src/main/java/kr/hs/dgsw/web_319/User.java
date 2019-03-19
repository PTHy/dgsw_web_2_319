package kr.hs.dgsw.web_319;

public class User {
    private int idx;
    private String name;
    private String email;

    public User() {}

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public User(int idx, String name, String email) {
        this.idx = idx;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "/" + email;
    }

}
