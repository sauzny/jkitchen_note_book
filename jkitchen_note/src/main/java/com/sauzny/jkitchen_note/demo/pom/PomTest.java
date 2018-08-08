package com.sauzny.jkitchen_note.demo.pom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.Test;


public class PomTest {

    @Test
	public void foo01() {
        
        try {
            
            MavenXpp3Reader reader = new MavenXpp3Reader();
            String myPom = System.getProperty("user.dir") + File.separator + "pom.xml";
            Model model = reader.read(new FileReader(myPom));
            
            List<Dependency> modelList = model.getDependencies();
            
            Properties properties = model.getProperties();
            properties.forEach((k,v) -> System.out.println(k + ":" + v));
            
            for(Dependency temp : modelList){
                String groupId = temp.getGroupId();
                String artifactId = temp.getArtifactId();
                String version = temp.getVersion();
                
                // version 处理
                if(version.startsWith("${")){
                    version = properties.getProperty(version.substring(2, version.length()-1));
                }
                
                System.out.println(groupId + "\t" + artifactId + "\t" + version);
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
