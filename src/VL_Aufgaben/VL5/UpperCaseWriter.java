package VL_Aufgaben.VL5;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class UpperCaseWriter extends FilterWriter {

    public UpperCaseWriter(Writer out)
    {
        super(out);
    }

    public void write(char[] cbuf,int off,int len) throws IOException
    {
        for(int il=0; il<cbuf.length;il++)
        {
            cbuf[il]=Character.toUpperCase(cbuf[il]);
        }
        super.write(cbuf,off,len);
    }


    public void write(int c) throws IOException {
        c=(int)Character.toUpperCase((char)c);
        super.write(c);
    }


    public void write(String str, int off, int len) throws IOException {
        str=str.toUpperCase();
        super.write(str, off, len);
    }
}
