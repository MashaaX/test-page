package interFacetraining;
public interface ICumlaude {
    public abstract void graduate();
    public abstract void getHighGPA();
    public abstract void studyInCampus();
}

class Student implements ICumlaude {
    protected String name;
    
    public Student(String name){
        this.name = name;
    }
    @Override
    public void studyInCampus(){
        System.out.println("I am a student, my name is " + this.name);
        System.out.println("I study in campus");
    }

    @Override
    public void graduate() {
        System.out.println("I Have Finished the thesis for Undergraduated");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is 3,1");
    }
}

class Undergraduated extends Student implements ICumlaude, IArchivers{

    public Undergraduated(String name) {
        super(name);
    }
    
    @Override
    public void studyInCampus(){
        System.out.println("I am a student, my name is " + this.name);
        System.out.println("I study in campus");
    }
    
    @Override
    public void graduate() {
        System.out.println("I have Finished the thesis for Undergraduated");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3,51");
    }

    @Override
    public void winTheCompetition() {
        System.out.println("I have won an INTERNATIONAL competition");
    }

    @Override
    public void publishTheJournal() {
        System.out.println("I publish articles in INTERNATIONAL journals");
    }
}

class Postgraduated extends Student implements ICumlaude, IArchivers{

    public Postgraduated(String name) {
        super(name);
    }
    @Override
    public void studyInCampus(){
        System.out.println("I am a student, my name is " + this.name);
        System.out.println("I study in campus");
    }
    @Override
    public void graduate() {
        System.out.println("I have finished the thesis for Postgraduated");
    }

    @Override
    public void getHighGPA() {
        System.out.println("My GPA is more than 3,71");
    }
//    

    @Override
    public void winTheCompetition() {
        System.out.println("I have won an INTERNATIONAL competition");
    }

    @Override
    public void publishTheJournal() {
        System.out.println("I publish articles in INTERNATIONAL journals");
    }
}

    class Rector {
    public void giveCumlaudeCertificate(IArchivers student){
        System.out.println("I am Rector, give a Cumlaude Certificate");
        System.out.println("Congratulations! Please introduce yourself..");
        
        student.winTheCompetition();
        student.publishTheJournal();
        
        System.out.println("------------------------------------------------");
        
    }
}

class program{
    public static void main(String[] args) {
        Rector MrRector = new Rector();
        
        Student ordinaryStudent = new Student("Charlie");
        Undergraduated undergraduatedCumlaude = new Undergraduated("Joe");
        Postgraduated postgraduatedCumlaude = new Postgraduated("Ben");
        
//        MrRector.giveCumlaudeCertificate((ICumlaude) ordinaryStudent);
//        MrRector.giveCumlaudeCertificate(undergraduatedCumlaude);
//        MrRector.giveCumlaudeCertificate(postgraduatedCumlaude);

        MrRector.giveCumlaudeCertificate(undergraduatedCumlaude);
        MrRector.giveCumlaudeCertificate(postgraduatedCumlaude);
    }
}