package data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Dataprovider {
    protected Properties prop = null;
    protected InputStream input = Dataprovider.class.getClassLoader().getResourceAsStream("testdata.properties");

    public Dataprovider() throws IOException {

        prop = new Properties();
        prop.load(input);

    }

    //get data from data sheet
    public String getValueByName(String name){
        return prop.getProperty(name);
    }


}

