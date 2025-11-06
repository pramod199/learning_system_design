//package machine_coding.razorpay;
//
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//class Document {
//    int id;
//    String text;
//
//    Document(int id, String text) {
//        this.id = id;
//        this.text = text;
//    }
//
//    @Override
//    public String toString() {
//        return "Doc" + id + ": " + text;
//    }
//}
//
//class Dataset {
//    Map<Integer, Document> documents = new HashMap<>();
//    Map<String, Map<Integer, Integer>> invertedIndex = new HashMap<>(); // term -> (docId -> frequency)
//    AtomicInteger docIdCounter = new AtomicInteger(1);
//
//    void addDocument(String text) {
//        int id = docIdCounter.getAndIncrement();
//        Document doc = new Document(id, text);
//        documents.put(id, doc);
//
//        String[] words = text.toLowerCase().split("\\W+");
//        Map<String, Integer> freqMap = new HashMap<>();
//
//        for (String word : words) {
//            if (word.isEmpty()) continue;
//            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
//        }
//
//        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
//            invertedIndex
//                .computeIfAbsent(entry.getKey(), k -> new HashMap<>())
//                .put(id, entry.getValue());
//        }
//    }
//
//    List<Document> search(String term) {
//        term = term.toLowerCase();
//        Map<Integer, Integer> docFreqs = invertedIndex.getOrDefault(term, Collections.emptyMap());
//
//        return docFreqs.entrySet().stream()
//                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
//                .map(entry -> documents.get(entry.getKey()))
//                .collect(Collectors.toList());
//    }
//}
//
//class SearchEngineService {
//    Map<String, Dataset> datasets = new HashMap<>();
//
//    void createDataset(String name) {
//        datasets.putIfAbsent(name, new Dataset());
//    }
//
//    void addDocument(String datasetName, String text) {
//        Dataset dataset = datasets.get(datasetName);
//        if (dataset != null) {
//            dataset.addDocument(text);
//        } else {
//            throw new IllegalArgumentException("Dataset not found");
//        }
//    }
//
//    List<Document> search(String datasetName, String term) {
//        Dataset dataset = datasets.get(datasetName);
//        if (dataset != null) {
//            return dataset.search(term);
//        } else {
//            throw new IllegalArgumentException("Dataset not found");
//        }
//    }
//}
//
//// Example usage
//public class InMemorySearchEngine {
//    public static void main(String[] args) {
//        SearchEngineService engine = new SearchEngineService();
//
//        engine.createDataset("techBlog");
//        engine.addDocument("techBlog", "apple is a fruit"); // Doc1
//        engine.addDocument("techBlog", "apple apple come on"); // Doc2
//        engine.addDocument("techBlog", "oranges are sour"); // Doc3
//        engine.addDocument("techBlog", "apple is sweet"); // Doc4
//        engine.addDocument("techBlog", "veggies are healthy"); // Doc5
//
//        List<Document> result = engine.search("techBlog", "apple");
//        for (Document doc : result) {
//            System.out.println(doc);
//        }
//    }
//}
