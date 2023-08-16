/*
* Represents a multimedia file.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultimediaFile {

    String multimediaFileName, dateCreated,
    length , framerate , frameWidth , frameHeight;

    byte[] multimediaFileChunk;
    int chunkOffset = 0;

    MultimediaFile(String filename , String dateCrated , String length , String framerate , String frameWidth , String frameHeight){
        this.multimediaFileName = filename;
        this.dateCreated = dateCrated;
        this.length = length;
        this.framerate = framerate;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public MultimediaFile (String filename , long size){

        this.multimediaFileName = filename;
        this.multimediaFileChunk = new byte[(int)size+512];

    }

    public void addChunk(byte[] chunk){

        for (int i = 0 ; i<512 ; i++){

            multimediaFileChunk[chunkOffset] = chunk[i];
            chunkOffset++;
        }
    }
}
