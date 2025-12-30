package lld_algomaster.stackoverflow.strategy;

import lld_algomaster.stackoverflow.entity.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
