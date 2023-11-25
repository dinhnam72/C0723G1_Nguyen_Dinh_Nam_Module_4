package com.example.bt2.service;


import com.example.bt2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showList();
    void add(Song song);
    Song findById(int id);
    void update(Song song);
}
