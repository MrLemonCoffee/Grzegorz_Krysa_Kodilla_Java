package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;

public class StreamMain {
    public static void main(String[] args) {
        Forum theUserList = new Forum();
        Map<Integer, ForumUser> theResultMap = theUserList.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> YEARS.between(user.getBirthDate(), LocalDate.now()) >= 20)
                .filter(user -> user.getPostQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        System.out.println("# elements: " + theResultMap.size());
        theResultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}