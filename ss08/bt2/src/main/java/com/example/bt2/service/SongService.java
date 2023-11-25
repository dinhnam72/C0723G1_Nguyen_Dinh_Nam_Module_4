package com.example.bt2.service;

import com.example.bt2.dto.SongDto;
import com.example.bt2.model.Song;
import com.example.bt2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> showList() {
        return songRepository.findAll();
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }
}
