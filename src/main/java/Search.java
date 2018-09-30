import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Search {
    public static String SearchLink(String str){
        String youtubeLinkForSearching = "https://www.youtube.com/results?search_query=";
        String youtubeSearchingResultLink = youtubeLinkForSearching + str.replaceAll(" ", "+");
        String youtubeLink = "https://www.youtube.com";
        String result = youtubeLink + GetLink(youtubeSearchingResultLink);
        return result;
    }

    private static String GetLink(String link){
        try {
            URL site = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                if (line.startsWith("<li><div class=\"yt-lockup")){
                    String[] wordArr = line.split(" ");
                    for (String word:wordArr) {
                        if (word.startsWith("href=")){
                            int begin = word.indexOf('"')+1;
                            int end = word.lastIndexOf('"');
                            return word.substring(begin, end);
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
