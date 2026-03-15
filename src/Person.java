class Person {
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Person {
    void display() {
        super.display(); // calls parent method
        System.out.println("Child display");
    }
}
