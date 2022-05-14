package com.codegym.dto;

import com.codegym.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

    public class SongDto {


    private Integer id;


    @NotBlank(message = "{name.notNull}")
    @Size(max = 800,message = "{name.limitCharacter800}")
    @Pattern(regexp = "^[a-zA-Z]+$",message ="{name.mistype}" )
    private String nameSong;

    @NotBlank(message = "{singer.notNull}")
    @Size(max = 300,message = "{singer.limitCharacter300}")
    @Pattern(regexp = "^[a-zA-Z]+$",message ="{singer.mistype}" )
    private String singerName;

    @NotBlank(message = "{typeMusic.notNull}")
    @Size(max = 1000,message = "{typeMusic.limitCharacter1000}")
    @Pattern(regexp = "^[,a-zA-Z]+$",message ="{typeMusic.mistype}" )
    private String typeMusic;
    private String fileMusic;

    public SongDto() {
    }

    public SongDto(String nameSong, String singerName, String typeMusic, String fileMusic) {
        this.nameSong = nameSong;
        this.singerName = singerName;
        this.typeMusic = typeMusic;
        this.fileMusic = fileMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }



    }
