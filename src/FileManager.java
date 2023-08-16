import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class FileManager {

    public void readFile(String filename){

        try {

            File file = new File(filename);

            MultimediaFile multimediafile = new MultimediaFile(filename,file.length());

            byte[] myBuffer = new byte[512];
            int bytesRead = 0;
            InputStream  in = new FileInputStream (file);
            while ((bytesRead = in.read(myBuffer,0,512)) != -1)
            {
                multimediafile.addChunk(myBuffer);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeFile(String filename){

        try {

            // create FileOutputStream from filename
            FileOutputStream fos = new FileOutputStream(filename);

            // create BufferedOutputStream for FileOutputStream
            BufferedOutputStream bos = new BufferedOutputStream(fos);

   //         bos.write(multimediafile.multimediaFileChunk);

        }
        catch (Exception e){

        }
    }

    public static void main (String[] args) {

        String filename = "src/sample-30s.mp4";

        FileManager a = new FileManager();
        a.readFile(filename);
    }
}
