package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public enum InformationUtil {
    WEB_URL("WebURL"){
        @Override
        public String getInformation() throws Exception{
            Properties prop = readPropertiesFile(System.getProperty("user.dir")+"/src/main/resources/application.properties");
            return prop.getProperty("baseURL");
        }
    };


    private String name;
    private static final Map<String, InformationUtil> DATA_MAP;

    InformationUtil(String name){
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    public abstract String getInformation() throws Exception;

    static {
        Map<String, InformationUtil> map = new ConcurrentHashMap<String, InformationUtil>();
        for(InformationUtil informationUtil : InformationUtil.values()){
            map.put(informationUtil.getName(), informationUtil);
        }
        DATA_MAP = Collections.unmodifiableMap(map);
    }

    public static InformationUtil get(String information){ return DATA_MAP.get(information);}

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
