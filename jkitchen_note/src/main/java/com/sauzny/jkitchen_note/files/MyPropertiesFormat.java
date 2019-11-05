package com.sauzny.jkitchen_note.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyPropertiesFormat {

    public static List<ConfigurationGroup> format() {
        // informix配置文件
        Path path = Paths.get("onconfig");
        Charset charset = StandardCharsets.UTF_8;

        List<ConfigurationGroup> result = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(path, charset);
            for (int i=0; i<lines.size(); i++) {
                String line = lines.get(i);
                if (line.startsWith("########")) {
                    int start = i;
                    int middle = i;
                    int end = i;
                    i++;
                    for( ; i<lines.size(); i++){
                        line = lines.get(i);
                        if(line.startsWith("########")){
                            middle = i;
                            break;
                        }
                    }
                    i++;
                    for(; i<lines.size(); i++){
                        line = lines.get(i);
                        if(line.startsWith("########")){
                            end = i;
                            break;
                        }
                        if(line.length() == 0){
                            end = middle;
                            break;
                        }
                    }
                    //System.out.println(String.format("%s-%s-%s", start, middle, end));
                    StringBuilder sb = new StringBuilder();
                    if(middle < end){
                        for(int t=start+1; t<middle; t++){
                            String nameLine = lines.get(t);
                            if(t>start+1) sb.append(" ");
                            sb.append(lines.get(t).substring(2));
                            if(nameLine.startsWith("# MQ")){
                                break;
                            }
                        }
                    }else{
                        sb.append(i);
                    }

                    String groupName = sb.toString();

                    if(groupName.contains(" - ")){
                        groupName = groupName.split(" - ")[0];
                    }

                    ConfigurationGroup configurationGroup = new ConfigurationGroup();
                    configurationGroup.setName(groupName);
                    result.add(configurationGroup);
                    System.out.println(configurationGroup.getName());
                /*
                }
                else if (line.trim().startsWith("[") && line.trim().endsWith("]")) {
                    ConfigurationGroup configurationGroup = new ConfigurationGroup();
                    configurationGroup.setName(line.substring(1, line.length() - 1));
                    result.add(configurationGroup);
                */
                } else if(line.startsWith("#")){


                } else if (!line.isBlank()) {
                    List<ConfigurationItem> configurationItems = result.get(result.size() - 1).getConfigurationItems();
                    ConfigurationItem configurationItem = new ConfigurationItem();
                    if(line.contains(" ")){
                        int index = line.indexOf(" ");
                        configurationItem.setKey(line.substring(0, index).trim());
                        configurationItem.setValue(line.substring(index).trim());
                    }else{
                        configurationItem.setKey(line);
                        configurationItem.setValue("");
                    }
                    configurationItems.add(configurationItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.remove(0);

        result.forEach(group -> {
            //System.out.println(group.getName());
            group.getConfigurationItems().forEach(item -> {
                System.out.println("  " + item.getKey() + "  " + item.getValue());
            });
        });

        return result;
    }

    static class ConfigurationGroup {
        private String name;
        private List<ConfigurationItem> configurationItems = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ConfigurationItem> getConfigurationItems() {
            return configurationItems;
        }

        public void setConfigurationItems(List<ConfigurationItem> configurationItems) {
            this.configurationItems = configurationItems;
        }
    }

    static class ConfigurationItem {
        private String key;
        private String value;
        private String nameZh;
        private String descEn;
        private String descZh;
        private List<String> options = new ArrayList<>();

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNameZh() {
            return nameZh;
        }

        public void setNameZh(String nameZh) {
            this.nameZh = nameZh;
        }

        public String getDescEn() {
            return descEn;
        }

        public void setDescEn(String descEn) {
            this.descEn = descEn;
        }

        public String getDescZh() {
            return descZh;
        }

        public void setDescZh(String descZh) {
            this.descZh = descZh;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }
    }

    public static void main(String[] args) {
        MyPropertiesFormat.format();
    }
}
