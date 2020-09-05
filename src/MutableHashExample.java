import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MutableHashExample {
    public static void main(String[] args) {
        Person person1 = new Person("Vadik", 25);
        Person person2 = new Person("Eugeiniy", 25);
        Person person3 = new Person("Vadik", 25);

        Set<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);

        person1.setAge(26);

        System.out.println(set.contains(person3));
    }

    public static class Person {
        private String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
