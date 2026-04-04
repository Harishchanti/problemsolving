package LLD.fileSystemWithDesignPattern.service;

import LLD.fileSystemWithDesignPattern.model.DirectoryNode;
import LLD.fileSystemWithDesignPattern.model.FSNode;
import LLD.fileSystemWithDesignPattern.model.FileNode;
import LLD.fileSystemWithDesignPattern.model.FileType;

/*
Factory Pattern
 */
public class FSNodeFactory {
    public static FSNode createNode(String name, FileType type) {
        if (type == FileType.FILE) return new FileNode(name);
        return new DirectoryNode(name);
    }
}
