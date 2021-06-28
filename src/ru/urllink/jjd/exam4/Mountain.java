package ru.urllink.jjd.exam4;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_mountains")
public class Mountain implements Cloneable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mountainID;

   @Column(nullable = false)
    private String name;
    private int height;

    public Mountain(){
        this("Гора по умолчанию", 300);
    }
    // конструктор
    public Mountain(String name, int height){
        setName(name);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("name < 2");
        }
        this.name = name;
    }

    private void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("height < 100");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mountain)) return false;
        Mountain mountain = (Mountain) o;
        return height == mountain.height &&
                Objects.equals(name, mountain.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }

    @Override
    public Mountain clone() {
        try {
            return (Mountain) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
