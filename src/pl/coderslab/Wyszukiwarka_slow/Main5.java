package pl.coderslab.Wyszukiwarka_slow;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {

        String url = "http://www.wp.pl/";
        String fileName = "popular_words.txt";
        String filterFileName = "filtered_popular_words.txt";
        String[] tab;
        String[] filterTab = {"oraz", "ponieważ", "tylko", "znów", "cały", "jako"};
        Path path = null, pathFilter = null;

        //get files "popular_words.txt" and "filtered_popular_words.txt"
        try {
            path = getPath(fileName);
            pathFilter = getPath(filterFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //write to "popular_words.txt"
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            for (Element elem : getTitles(url)) {
                tab = elem.text().replaceAll("[^a-zA-Z0-9ąćęłńóśźż ]", "").split(" ");
                for (String word : tab) {
                    if (word.length() > 3) {
                        writer.write(word + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read from "popular_words.txt" and write to "filtered_popular_words.txt"
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(pathFilter, StandardCharsets.UTF_8)) {

            String str;
            while ((str = reader.readLine()) != null) {
                if (!Arrays.asList(filterTab).contains(str)) {
                    writer.write(str + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Elements getTitles(String url) {
        Connection connect = Jsoup.connect(url);
        Elements links = null;
        try {
            Document document = connect.get();
            links = document.select("span.title");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    private static Path getPath(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        return path;
    }

}


