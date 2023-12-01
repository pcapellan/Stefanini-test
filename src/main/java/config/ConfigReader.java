package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "/config.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar o arquivo de configuração");
        }
    }

    public static String getCadastroUsuariosUrl() {
        return properties.getProperty("url_cadastro_usuarios");
    }
}
