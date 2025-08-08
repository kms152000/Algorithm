class Solution {
    public String solution(String my_string) {
        String[] vowels = {"a", "e", "i", "o", "u"};

        for (String vowel : vowels) {
            my_string = my_string.replace(vowel, "");
        }
        return my_string;
    }
}