package com.sauzny.jkitchen_note.oak.clone;

public class Bag3 implements Cloneable{//学生的书包  
    private int width;//宽  
    private String logo;//品牌  
    public int getWidth() {  
        return width;  
    }  
    public void setWidth(int width) {  
        this.width = width;  
    }  
    public String getLogo() {  
        return logo;  
    }  
    public void setLogo(String logo) {  
        this.logo = logo;  
    }  
      
    @Override  
    protected Bag3 clone() throws CloneNotSupportedException {  
        return (Bag3)super.clone();  
    }  

}
