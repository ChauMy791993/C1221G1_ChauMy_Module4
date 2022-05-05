package codegym.model;

public class Song {
    private String nameSong;
    private String singerName;
    private String typeMusic;
    private String fileMusic;

    public Song() {
    }

    public Song(String nameSong, String singerName, String typeMusic, String fileMusic) {
        this.nameSong = nameSong;
        this.singerName = singerName;
        this.typeMusic = typeMusic;
        this.fileMusic = fileMusic;
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
