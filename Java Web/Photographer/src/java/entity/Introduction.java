/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Chucnc
 */
public class Introduction {
    private String image; 
    private String descript; 
    private String aboutme; 

    public Introduction() {
    }

    public Introduction(String image, String descript, String aboutme) {
        this.image = image;
        this.descript = descript;
        this.aboutme = aboutme;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
    
}
