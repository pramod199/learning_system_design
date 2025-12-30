package lld_algomaster.stackoverflow.strategy;


import lld_algomaster.stackoverflow.entity.Question;
import lld_algomaster.stackoverflow.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserSearchStrategy implements SearchStrategy {
    private final User user;

    public UserSearchStrategy(User user) {
        this.user = user;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getAuthor().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}