public class Cookbook {
    private String title;
    private Recipe featured;


  //  public

    //constructor
    public Cookbook(String title, Recipe featured){
        this.title = title;
        this.featured = featured;
    }

    //methods
    public Recipe showFeatured(){
        return featured;
    }

    public String toString(){
        return "Title: " + title + ", featured: " + featured;
    }



}
