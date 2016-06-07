package vaksys.in.volleyjsondemo.pojo;

import java.util.List;

/**
 * Created by dell980 on 4/13/2016.
 */
public class NewResponse {

    /**
     * name : Brad Pitt
     * description : William Bradley 'Brad' Pitt is an American actor and film producer. He has received a Golden Globe Award, a Screen Actors Guild Award, and three Academy Award nominations in acting categories
     * dob : December 18, 1963
     * country : United States
     * height : 1.80 m
     * spouse : Jennifer Aniston
     * children : Shiloh Nouvel Jolie-Pitt, Maddox Chivan Jolie-Pitt
     * image : http://microblogging.wingnity.com/JSONParsingTutorial/brad.jpg
     */

    private List<ActorsBean> actors;

    public List<ActorsBean> getActors() {
        return actors;
    }

    public void setActors(List<ActorsBean> actors) {
        this.actors = actors;
    }

    public static class ActorsBean {
        private String name;
        private String description;
        private String dob;
        private String country;
        private String height;
        private String spouse;
        private String children;
        private String image;

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

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getSpouse() {
            return spouse;
        }

        public void setSpouse(String spouse) {
            this.spouse = spouse;
        }

        public String getChildren() {
            return children;
        }

        public void setChildren(String children) {
            this.children = children;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
