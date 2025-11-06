package machine_coding.razorpay;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Document {
    int id;
    String text;

    Document(int id, String text) {
        this.id = id;
        this.text = text;
    }

    int getTermFrequency(String term) {
        String[] words = text.toLowerCase().split("\\W+");
        int count = 0;
        for (String word : words) {
            if (word.equals(term.toLowerCase())) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Doc" + id + ": " + text;
    }
}

class Dataset {
    Map<Integer, Document> documents = new HashMap<>();
    AtomicInteger docIdCounter = new AtomicInteger(1);

    void addDocument(String text) {
        int id = docIdCounter.getAndIncrement();
        documents.put(id, new Document(id, text));
    }

    List<Document> search(String term) {
        return documents.values().stream()
                .filter(doc -> doc.getTermFrequency(term) > 0)
                .sorted((a, b) -> Integer.compare(
                        b.getTermFrequency(term), a.getTermFrequency(term)))
                .collect(Collectors.toList());
    }
}

class SearchEngineService {
    Map<String, Dataset> datasets = new HashMap<>();

    void createDataset(String name) {
        datasets.putIfAbsent(name, new Dataset());
    }

    void addDocument(String datasetName, String text) {
        Dataset dataset = datasets.get(datasetName);
        if (dataset != null) {
            dataset.addDocument(text);
        } else {
            throw new IllegalArgumentException("Dataset not found");
        }
    }

    List<Document> search(String datasetName, String term) {
        Dataset dataset = datasets.get(datasetName);
        if (dataset != null) {
            return dataset.search(term);
        } else {
            throw new IllegalArgumentException("Dataset not found");
        }
    }
}

// Example usage
public class InMemorySearchEngineInefficient {
    public static void main(String[] args) {
        SearchEngineService engine = new SearchEngineService();

        engine.createDataset("techBlog");
        engine.addDocument("techBlog", "apple is a fruit"); // Doc1
        engine.addDocument("techBlog", "apple apple come on"); // Doc2
        engine.addDocument("techBlog", "oranges are sour"); // Doc3
        engine.addDocument("techBlog", "apple is sweet"); // Doc4
        engine.addDocument("techBlog", "veggies are healthy"); // Doc5

        List<Document> result = engine.search("techBlog", "apple");
        for (Document doc : result) {
            System.out.println(doc);
        }
    }
}
