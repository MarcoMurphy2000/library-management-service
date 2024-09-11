package za.co.dvt.lib_management_system.entity.member;

public class Member {
    private String name;
    private String surname;
    private int id;

    public Member(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%d", name, surname, id);
    }
}

