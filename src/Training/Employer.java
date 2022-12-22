package Training;

public class Employer /*implements Comparable<Training.Employer>*/ {

    int age;
    String name;

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }

    public Employer(int age, String name) {
        this.age = age;
        this.name = name;
    }

  /*  @Override
    public int compareTo(Training.Employer employer) {
        for (int i = 0; i < this.name.length(); i++) {
            for (int j = 0; j < employer.name.length(); j++) {
                if (this.name.charAt(i) > employer.name.charAt(i)){
                    return 1;
                }
                if (this.name.charAt(i) < employer.name.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }*/

}
