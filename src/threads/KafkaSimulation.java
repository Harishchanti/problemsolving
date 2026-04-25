package threads;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// Message model
class Message {
    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

// Topic with partitions
class Topic {
    private final List<BlockingQueue<Message>> partitions;

    public Topic(int numPartitions) {
        partitions = new ArrayList<>();
        for (int i = 0; i < numPartitions; i++) {
            partitions.add(new LinkedBlockingQueue<>());
        }
    }

    public BlockingQueue<Message> getPartition(int index) {
        return partitions.get(index);
    }

    public int numPartitions() {
        return partitions.size();
    }
}

// Producer
class Producer {
    private final Topic topic;
    private final AtomicInteger counter = new AtomicInteger(0);

    public Producer(Topic topic) {
        this.topic = topic;
    }

    public void send(String value) {
        int partition = counter.getAndIncrement() % topic.numPartitions();
        try {
            topic.getPartition(partition).put(new Message(value));
            System.out.println(
                    "Produced: " + value + " -> Partition " + partition);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Consumer
class Consumer implements Runnable {
    private final String name;
    List<BlockingQueue<Message>> assignedPartitions = new ArrayList<>();
    private volatile boolean running = true;

    public Consumer(String name) {
        this.name = name;
    }

    public void assignPartitions(List<BlockingQueue<Message>> partitions) {
        this.assignedPartitions = partitions;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            for (BlockingQueue<Message> partition : assignedPartitions) {
                Message msg = partition.poll();
                if (msg != null) {
                    System.out.println(name + " consumed: " + msg.getValue());
                }
            }
            try {
                Thread.sleep(200); // simulate processing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " stopped.");
    }
}

// Consumer Group with Rebalancing
class ConsumerGroup {
    private final List<Consumer> consumers = new ArrayList<>();
    private final Topic topic;

    public ConsumerGroup(Topic topic) {
        this.topic = topic;
    }

    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
        rebalance();
    }

    public void removeConsumer(Consumer consumer) {
        consumers.remove(consumer);
        consumer.stop();
        rebalance();
    }

    private void rebalance() {
        System.out.println("\n--- Rebalancing ---");

        int numConsumers = consumers.size();
        int numPartitions = topic.numPartitions();

        for (Consumer consumer : consumers) {
            consumer.assignPartitions(new ArrayList<>());
        }

        for (int i = 0; i < numPartitions; i++) {
            Consumer consumer = consumers.get(i % numConsumers);
            consumer.assignedPartitions.add(topic.getPartition(i));
        }

        for (Consumer consumer : consumers) {
            System.out.println("Assigned partitions to " + consumer);
        }
    }
}

// Main class
public class KafkaSimulation {
    public static void main(String[] args) throws InterruptedException {

        Topic topic = new Topic(3);
        Producer producer = new Producer(topic);

        ConsumerGroup group = new ConsumerGroup(topic);

        Consumer c1 = new Consumer("Consumer-1");
        Consumer c2 = new Consumer("Consumer-2");
        Consumer c3 = new Consumer("Consumer-3");

        group.addConsumer(c1);
        group.addConsumer(c2);
        group.addConsumer(c3);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(c1);
        executor.submit(c2);
        executor.submit(c3);

        // Producing messages
        for (int i = 0; i < 5; i++) {
            producer.send("Message-" + i);
            Thread.sleep(100);
        }

        // Simulate consumer failure
        System.out.println("\n*** Removing Consumer-2 ***");
        group.removeConsumer(c2);

        // Produce more messages
        for (int i = 5; i < 10; i++) {
            producer.send("Message-" + i);
            Thread.sleep(100);
        }

        Thread.sleep(3000);
        executor.shutdownNow();
    }
}