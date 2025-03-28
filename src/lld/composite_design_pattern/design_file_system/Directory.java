package lld.composite_design_pattern.design_file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj) {
        fileSystemList.add(fileSystemObj);
    }

    @Override
    public void ls() {
        System.out.println("directory name " + directoryName);
        for (FileSystem fileSystemObj : fileSystemList) {
            fileSystemObj.ls();
        }
    }
}
