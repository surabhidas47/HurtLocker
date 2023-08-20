import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        //findItem((pt.splitText(input)));

    }



    public ArrayList<String> splitText(String rawText) {

        String [] entries = rawText.split("##");
        ArrayList<String> entriesAL = new ArrayList<>(Arrays.asList(entries));

//        for (String s: entriesAL){
//            System.out.println(s);
//        }
        return entriesAL;

    }

    public static ArrayList<Groceries> createGroceryList (ArrayList <String> entriesAl){

        ArrayList<Groceries> glist = new ArrayList<>();

        for(String x: entriesAl){
            //now for each line i want to break into each part of groceries
            String myPattern = "[nN]\\w+:(\\w*);\\w{5}:(\\d.\\d{2})?;\\w{4}:(\\w{4}).\\w{10}:(\\d.\\d{2}.\\d{4})";
            Pattern pt = Pattern.compile(myPattern);

            Matcher matcher = pt.matcher(x);
            if (matcher.find()){
                String name = matcher.group(1);
                String price = matcher.group(2);
                String type = matcher.group(3);
                String expiration = matcher.group(4);

                Groceries groceries = new Groceries(name,price,type,expiration);
                glist.add(groceries);

            }


        }
        return glist;

    }




//    public static void findItem (ArrayList <String> entriesAl) {
//
//
//        String myPattern = "[nN]\\w+:(\\w*);\\w{5}:(\\d.\\d{2})?;\\w{4}:(\\w{4}).\\w{10}:(\\d.\\d{2}.\\d{4})";
//        Pattern pt = Pattern.compile(myPattern);
//
//        HashMap<String, ArrayList<String>> itemData = new HashMap<>();
//
//        for (String entry: entriesAl) {
//            Matcher matcher = pt.matcher(entry);
//            if (matcher.find()){
//                String name = matcher.group(1);
//                String price = matcher.group(2);
//                String type = matcher.group(3);
//                String expiration = matcher.group(4);
//
//
//
//            }
//
//        }
//
//    }









}
