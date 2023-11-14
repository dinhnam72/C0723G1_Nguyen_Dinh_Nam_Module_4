package com.example.bt2.Serivce;

import com.example.bt2.Repository.ISearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService implements ISearchService{
    @Autowired
    private ISearchRepository searchRepository;
    @Override
    public String result(String keyWord) {
        return searchRepository.result(keyWord);
    }
}
