package org.example;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

public class AddedFriend {
    private String name;
    private String description = "";
    private String deafultImagePath = "friend_default.png";

    private Image profilePicture;

    public AddedFriend(String name) throws IOException {
        this.name = name;
        profilePicture = ImageIO.read(new File(deafultImagePath));
//        profilePicture = profilePicture.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    }

    public AddedFriend(String name, Image newProfilePicture) {
        this.name = name;
        profilePicture = newProfilePicture;
//        profilePicture = profilePicture.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }
}
