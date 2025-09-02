import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    private static Logger instance;  //only instance of logger
    // use to write to file //handles writing text into a file
    private BufferedWriter writer;
    private String fileName;          // name of the current file

    // private Constructor
    private Logger() {
        this.fileName = "default_log.txt";  // default file name
        openFile(); // call openfile to prepare writing into current file
    }

    // create a new logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    //open new file
    private void openFile() {
        try {
            //append:prevent of overwrite, new logs go to the end of the file
            writer = new BufferedWriter(new FileWriter(fileName, true)); // append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // تغییر فایل لاگ
    public synchronized void setFileName(String fileName) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileName = fileName;
        openFile();
    }

    // Writes a log message
    public synchronized void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();  //make sure its saved immediately
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
