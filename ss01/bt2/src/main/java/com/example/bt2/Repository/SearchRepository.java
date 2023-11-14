package com.example.bt2.Repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class SearchRepository implements ISearchRepository {
    private static Map<String, String> dictionary = new LinkedHashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("sorry", "xin lỗi");
        dictionary.put("me", "tôi");
        dictionary.put("you", "bạn");
    }


    @Override
    public String result(String keyWord) {
        Set<String> string = dictionary.keySet();
        for (String s : string) {
            if (s.equals(keyWord)){
                return dictionary.get(s);
            }
        }
        return null;
    }
}
