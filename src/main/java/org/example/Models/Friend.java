package org.example.Models;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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

    private transient  Image profilePicture;

    @SneakyThrows
    public Friend(String nickname, String name) {
        this.nickname = nickname;
        this.name = name;
        profilePicture = ImageIO.read(new File(defaultImagePath));
    }

    public Friend(String name, Image newProfilePicture) {
        this.name = name;
        profilePicture = newProfilePicture;
    }
}
