package netukr.mail.auto.helpers;

import java.io.File;
import java.net.URL;

public class ReaderFilesFromResources {
        // get file from classpath, resources folder
        public static File getFileFromResources(String fileName) {
        ReaderFilesFromResources resources = new ReaderFilesFromResources();
        return resources.getFileFromResourcesLocal(fileName);
    }

        private File getFileFromResourcesLocal(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file " + fileName + " is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

        public static URL getUrlFromResources(String fileName) {
        ReaderFilesFromResources resources = new ReaderFilesFromResources();
        return resources.getUrlFromResourcesLocal(fileName);
    }

        // get file url classpath, resources folder
        private URL getUrlFromResourcesLocal(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file " + fileName + " is not found!");
        }
        return resource;
    }
}