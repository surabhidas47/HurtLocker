import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatMatch {

    //first i have to split the text by ##
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        return result;
    }

    public static void main(String[] args) throws Exception{

        PatMatch pt =new PatMatch();

        String input = pt.readRawDataToString();
        findItem((pt.splitText(input)));

    }



    public ArrayList<String> splitText(String rawText) {

        String [] entries = rawText.split("##");
        ArrayList<String> entriesAL = new ArrayList<>(Arrays.asList(entries));

//        for (String s: entriesAL){
//            System.out.println(s);
//        }
        return entriesAL;

    }

    public static void findItem (ArrayList <String> entriesAl) {


        String myPattern = "[nN]\\w+:(\\w*);\\w{5}:(\\d.\\d{2})?;\\w{4}:(\\w{4}).\\w{10}:(\\d.\\d{2}.\\d{4})";

        Pattern pt = Pattern.compile(myPattern);

        for (String entry: entriesAl) {
            Matcher matcher = pt.matcher(entry);
            if (matcher.find()){
                String name = matcher.group(1);
                String price = matcher.group(2);
                String type = matcher.group(3);
                String expiration = matcher.group(4);



            }

        }




    }









}
