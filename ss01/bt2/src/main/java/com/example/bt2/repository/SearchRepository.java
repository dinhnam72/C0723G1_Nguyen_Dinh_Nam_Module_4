package com.example.bt2.repository;

import org.springframework.stereotype.Repository;

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
        String result;
        result = dictionary.get(keyWord);
        if (result != null) {
            return result;
        } else {
            return "Từ này không có trong hệ thống";
        }
    }
}
