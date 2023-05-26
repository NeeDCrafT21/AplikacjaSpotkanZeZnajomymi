package org.example.Models;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Friend {
    private String name;
    private String description = "";
    private String defaultImagePath = "friend_default.png";

    private Image profilePicture;

    public Friend(String name) throws IOException {
        this.name = name;
        profilePicture = ImageIO.read(new File(defaultImagePath));
    }

    public Friend(String name, Image newProfilePicture) {
        this.name = name;
        profilePicture = newProfilePicture;
    }
}
