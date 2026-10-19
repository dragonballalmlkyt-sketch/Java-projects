public class studentGrade {
        public static void main(String[] args) {

            Student student = new Student("John Doe", 85.0, 92.0, 78.0);
            System.out.println("Validation: " + student.CheckValid());

            System.out.println("Grades: " + student.getGrade());

            System.out.println("Average: " + student.calculateAverage());

            System.out.println("Your final grade is: " + student.getLetterGrade());

            if (student.updateGrade("exam1", 95.0)) {
                System.out.println("Exam 1 grade updated successfully.");
                System.out.println("Updated Grades: " + student.getGrade());
                System.out.println("New Average: " + student.calculateAverage());
                System.out.println("New Letter Grade: " + student.getLetterGrade());


            } else {
                System.out.println("Failed to update Exam 1 grade.");
            }


        }

        static class Student {
            private String name;
            private double exam1grade;
            private double exam2grade;
            private double exam3grade;

            
            public Student(String name, double exam1grade, double exam2grade, double exam3grade) {
                this.name = name;
                if(exam1grade < 0 || exam1grade > 100 || exam2grade < 0 || exam2grade > 100 || exam3grade < 0 || exam3grade > 100) {
                    throw new IllegalArgumentException("Grades must be between 0 and 100.");
                }
                this.exam1grade = exam1grade;
                this.exam2grade = exam2grade;
                this.exam3grade = exam3grade;
            }

            
            public String CheckValid() {
                if(exam1grade < 0 || exam1grade > 100 || exam2grade < 0 || exam2grade > 100 || exam3grade < 0 || exam3grade > 100) {
                    return "Grades must be between 0 and 100.";
                }
                return "Valid";
            }


            public double calculateAverage() {
                return (exam1grade + exam2grade + exam3grade) / 3;
            }

            public String getLetterGrade() {
                double average = calculateAverage();
                if (average >= 90) {
                    return "A";
                } else if (average >= 80) {
                    return "B";
                } else if (average >= 70) {
                    return "C";
                } else if (average >= 60) {
                    return "D";
                } else {
                    return "F";
                }
            }

            public boolean updateGrade(String examName, double newGrade) {
                if(examName == null || newGrade < 0 || newGrade > 100) {
                    return false;
                }
                switch(examName) {
                    case "exam1":
                        exam1grade = newGrade;
                        break;
                    case "exam2":
                        exam2grade = newGrade;
                        break;
                    case "exam3":
                        exam3grade = newGrade;
                        break;
                    default:
                        return false;
                }
                return true;
            }

            public String getGrade(){
                return "Exam 1: " + exam1grade + ", Exam 2: " + exam2grade + ", Exam 3: " + exam3grade;
            }
        }
    
}
