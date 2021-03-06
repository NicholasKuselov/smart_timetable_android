package smarttimetable.main.Model.DBModels;

public class GroupForView {
    public Group group;
    public Course course;

    public GroupForView(Group group, Course course) {
        this.group = group;
        this.course = course;
    }

    public String GetAbbreviation()
    {
        String[] words = group.name.split(" ");
        String abb = "";
        if(words.length == 0)
        {
            return null;
        }else if(words.length < 2){
            abb = words[0];
        }else{
            for (String word: words) {
                abb = abb + word.charAt(0);
            }
            abb.toUpperCase();
        }

        abb = abb + " " +course.getNumber();
        return abb;

    }

}
