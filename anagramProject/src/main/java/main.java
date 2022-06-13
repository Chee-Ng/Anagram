import java.util.*;
import java.util.stream.Collectors;

class main {

    static List<String> testData = Arrays.asList(new String[]{"ant", "tan", "jam", "dam"});


    public static void main(String[] args) {
        System.out.println("Hello World");
        var result = findAnagram(testData);

        for (String a : result) {
            System.out.println(a);
        }
    }

    static Collection<String> findAnagram(List<String> testData) {

        var dictionary = testData.stream().collect(Collectors.toMap(entry -> entry, entry -> entry.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()));

        var anagrams = new HashMap<String, List<String>>();
        for (Map.Entry<String, String> entry: dictionary.entrySet()) {
            if (anagrams.containsKey(entry.getValue())) {
                anagrams.get(entry.getValue()).add(entry.getKey());
            } else {
                anagrams.put([entry.getKey()]);
            }

            anagrams.getOrDefault(entry.getValue(), new ArrayList<>()).add(entry.getKey());
        };


        return dictionary.values();
    }
};




