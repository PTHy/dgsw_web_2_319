package kr.hs.dgsw.web_319;

import java.util.List;

public interface UserService {
    List<User> userList();
    User view(int idx);
    User find1(String name);
    User find2(String name);
    User find3(String name);
    boolean add(User user);
    User update(User user);
    boolean delete(int idx);
}
