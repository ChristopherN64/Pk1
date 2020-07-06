package VL_Aufgaben.VL5;

import java.io.*;

public class start {
    public static void main(String[] args) throws IOException {
        File fFrom = new File("C:\\Users\\style\\Desktop\\test.pdf");
        File fTo = new File("C:\\Users\\style\\Desktop\\testCopy.txt");


        PrintWriter pw = new PrintWriter(System.out);
        FileWriter fw = new FileWriter(fTo);


        UpperCaseWriter ucw = new UpperCaseWriter(pw);
        ucw.write("hallo",0,4);

    }


    public static void sayHello(OutputStream s) throws IOException {
        String t = "Hello World";
        OutputStreamWriter sw = new OutputStreamWriter(s);
        sw.write(t.toCharArray());
        sw.flush();
    }

    public static void copyBuf(File from, File to)
    {
        try(FileInputStream fIn = new FileInputStream(from);
            FileOutputStream fOut = new FileOutputStream(to);
            BufferedOutputStream bOut = new  BufferedOutputStream(fOut);)
        {
            int iByte = fIn.read();
            while(iByte!=-1)
            {
                //System.out.println("Lese in Buffer");
                bOut.write(iByte);
                iByte= fIn.read();
            }
            //System.out.println("Buffer in Datei schreiben");
            bOut.flush(); //Schreiben des Buffers in den Übergebenen Stream
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



    public static void copy(File from, File to) throws IOException {
        RandomAccessFile rafFrom=null;
        RandomAccessFile rafTo=null;
        try
        {
            rafFrom = new RandomAccessFile(from,"r");
            rafTo = new RandomAccessFile(to,"rw");
            System.out.println("Pointer vor read: "+rafFrom.getFilePointer());
            int iByte = rafFrom.read();
            while(iByte!=-1)
            {
                System.out.println("Pointer vor write: "+rafTo.getFilePointer());
                rafTo.write(iByte);
                System.out.println("Pointer nach write: "+rafTo.getFilePointer());
                //rafTo.skipBytes(1);

                //rafFrom.skipBytes(1);
                System.out.println("Pointer vor read: "+rafFrom.getFilePointer());
                iByte= rafFrom.read();
                System.out.println("Pointer vor read: "+rafFrom.getFilePointer());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                rafFrom.close();
                rafTo.close();
            }
            catch (Exception e)
            {
                System.out.println("Fehler beim Close: "+e.getMessage());
                e.printStackTrace();
                throw e;


            }
        }
    }

    public static void cat(File quelle)
    {
        try(RandomAccessFile rafQuelle = new RandomAccessFile(quelle,"r");)
        {

            int iByteBuff=rafQuelle.read();
            while(iByteBuff != -1)
            {
                System.out.print((char)iByteBuff);
                iByteBuff = rafQuelle.read();

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}
