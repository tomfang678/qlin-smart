import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;


public class Program {
    public static void main(String[] args) {
        java.util.List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        File configFile = new File("./src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);

        try {
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("生成完成。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
