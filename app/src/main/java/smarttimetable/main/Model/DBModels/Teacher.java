package smarttimetable.main.Model.DBModels;

public class Teacher {
    int idTeacher;
    String name;
    String mail;

    public Teacher(int idTeacher, String name, String mail) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.mail = mail;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object teacher)
    {
        Teacher t = (Teacher)teacher;
        if (this.idTeacher == t.idTeacher && this.mail.equals(t.mail) && this.name.equals(t.name))
        {
            return true;
        }else{
            return false;
        }
    }
}
