package LLD.fileSystemWithDesignPattern.service;

import LLD.fileSystemWithDesignPattern.model.FileNode;

public interface StorageStrategy {
    void write(FileNode file, String data);
    String read(FileNode file);
}
