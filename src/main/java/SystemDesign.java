// Design next classes: human, horse,  centaur


// Людина
class Human {
    private String Name;
    private Integer Age;

    public Integer getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }

    public Human(String name, Integer age) {
        this.Name = name;
        this.Age = age;
    }

    public void Eat(){
    }

    public void Run(){
    }
}

// Кінь
class Horse {
    public void Eat(){
    }

    public void Run(){
    }
}

// Кентавр
class Centaur {
}
