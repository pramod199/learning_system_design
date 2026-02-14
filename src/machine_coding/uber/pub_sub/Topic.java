package machine_coding.uber.pub_sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Topic {
    String name;
    List<Partition> partitions;

    ExecutorService deliveryExecutor;

    public Topic(String name, int partitionCount, ExecutorService deliveryExecutor) {
        this.name = name;
        this.partitions = new ArrayList<>();
        this.deliveryExecutor = deliveryExecutor;
        for (int i = 0; i < partitionCount; i++) {
            partitions.add(new Partition(i, deliveryExecutor));
        }
    }

    public Partition getPartition(int partitionId) {
        return partitions.get(partitionId);
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public String getName() {
        return name;
    }
}
