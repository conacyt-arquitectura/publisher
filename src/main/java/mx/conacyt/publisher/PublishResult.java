package mx.conacyt.publisher;

import java.time.Instant;

import org.apache.kafka.clients.producer.RecordMetadata;

public class PublishResult {
    
    private String topic;
    private int partition;
    private long offset;
    private Instant timestamp;

    public PublishResult(RecordMetadata metadata) {
        this.topic = metadata.topic();
        this.partition = metadata.partition();
        this.offset = metadata.offset();
        this.timestamp = Instant.ofEpochMilli(metadata.timestamp());
    }

    public PublishResult() {
        this.topic = "N/A";
        this.partition = -1;
        this.offset = -1;
        this.timestamp = Instant.now();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}