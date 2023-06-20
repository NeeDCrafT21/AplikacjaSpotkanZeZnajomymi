package org.example.Models;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class Friend implements Serializable {

    private String name;
    private String nickname;
    private String description = "";
    private String defaultImagePath = "friend_default.png";
    private String imageURLPath = null;

    private transient Image profilePicture;

    @SneakyThrows
    public Friend(String nickname, String name) {
        this.nickname = nickname;
        this.name = name;
        profilePicture = ImageIO.read(new File(defaultImagePath));
    }

    @SneakyThrows
    public Friend(String nickname, String name, String imageURLPath) {
        this.nickname = nickname;
        this.name = name;
        URL imageURL = new URL(imageURLPath);
        profilePicture = ImageIO.read(imageURL);
    }
}
