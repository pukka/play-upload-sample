package models;

import java.util.*;

import com.avaje.ebean.Model;
import play.data.validation.Constraints.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image extends Model {
    @Id
    public Long id;

    @Required
    @Column(nullable = false)
    public String tag;

    @Column(nullable = false, name = "image_name")
    public String imageName;

    public static Finder<Long, Image> find = new Finder(
        Long.class, Image.class
    );

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        String[] list = {"wara", "oko", "naki", "raku"};
        for(String tag: list) options.put(tag, tag);
        return options;
    }

    public static List all() {
        return find.all();
    }

    public static void add(Image image) {
        image.save();
    }
}    
