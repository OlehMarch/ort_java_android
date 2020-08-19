package io;

public class FileImpl {
    public static IFileIO GetInstance(String fileFormat, String filePath){
        IFileIO obj = null;
        switch (fileFormat){
            case "CSV": obj = new FileCsv(filePath); break;
            case "JSON": obj = new FileJson(filePath); break;
            case "XML": obj = new FileXml(filePath); break;
            case "YAML": obj = new FileYaml(filePath); break;
            default: break;
        }
        return obj;
    }
}
