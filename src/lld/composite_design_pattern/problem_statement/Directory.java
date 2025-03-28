package lld.composite_design_pattern.problem_statement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;

    List<Object> objectList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectList = new ArrayList<>();
    }

    // we need to put check of type of object and then call ls method
    public void ls() {
        System.out.println("directory name " + directoryName);
        for (Object obj : objectList) {
            if (obj instanceof File) {
                ((File) obj).ls();
            } else {
                ((Directory) obj).ls();
            }
        }
    }


    public void add(Object object) {
        objectList.add(object);
    }
}
