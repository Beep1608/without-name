package linear.regression.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReaderCSV {
    private String fileName;    // nombre del archivo (opcional)
    private String line;        // línea actual leída
    private String separator;   // separador (ejemplo: ",")
    private URL filePath;       // ubicación del archivo CSV

    // Constructor vacío
    public ReaderCSV() {
        this.separator = ","; // separador por defecto
    }

    // Constructor con URL
    public ReaderCSV(URL filePath) {
        this(filePath, ",");
    }

    // Constructor con URL y separador
    public ReaderCSV(URL filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
        this.fileName = filePath.getFile();
    }

    // Método que lee usando la URL guardada en el objeto
    public List<String[]> readAll() {
        if (filePath == null) {
            throw new IllegalStateException("El archivo CSV no ha sido definido.");
        }
        return read(filePath);
    }

    // Método que lee un CSV desde cualquier URL pasada como parámetro
    public List<String[]> read(URL filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(filePath.openStream()))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    // Getters y Setters
    public void setFilePath(URL filePath) {
        this.filePath = filePath;
        this.fileName = filePath.getFile();
    }

    public URL getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}