package kr.hs.dgsw.web_319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    private List<User> userList;
    private User found;

    public UserServiceImpl() {

        this.userList = new ArrayList<>();

        this.userList.add(new User(1,"user1","user1@naver.com"));
        this.userList.add(new User(2,"user2","user2@naver.com"));
        this.userList.add(new User(3,"user3","user3@naver.com"));
    }

    @Override
    public List<User> userList() {
        return this.userList;
    }

    @Override
    public boolean add(User user) {
        User found = this.view(user.getIdx());
        if (found != null)
            return false;
        this.userList.add(user);
        return true;
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getIdx());
        if(found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(int idx) {
        User found = this.view(idx);
        if(found != null) {
            userList.remove(found);
            return true;
        }
        return false;
    }

    /*
        for문 사용
     */

    @Override
    public User view(int idx) {
        for(int i = 0; i < userList.size(); i++) {
            found = userList.get(i);
            if ( found.getIdx() == idx )
                return found;
        }
        return null;
    }

    /*
        Iterator 사용
     */

    @Override
    public User find1(String name) {
        Iterator<User> iterator = this.userList.iterator();
        while(iterator.hasNext()) {
            found = iterator.next();
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    /*
        forEach 사용
     */

    @Override
    public User find2(String name) { // Java 5+
        for(User found : userList)
            if(found.getName().equals(name))
                return found;
        return null;
    }

    /*
        Java Stream 사용
     */

    @Override
    public User find3(String name) {
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }
}
