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
public class ImageGallery {
    private String image; 
    private int galleryId; 

    public ImageGallery() {
    }

    public ImageGallery(String image, int galleryId) {
        this.image = image;
        this.galleryId = galleryId;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }
    
    
}
