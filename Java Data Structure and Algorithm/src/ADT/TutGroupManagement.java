package ADT;



import ADT.SortedListInterface;
import Entity.Student;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

    public class TutGroupManagement<T extends Student> implements SortedListInterface<T> {

    private Student[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 20;
    
    private TutGroupManagement<Student> tutGroup2;
    

    public TutGroupManagement() {
        this(DEFAULT_CAPACITY);
       
    }

    public TutGroupManagement(int initialCapacity) {
        numberOfEntries = 0;
        array = new Student[initialCapacity];
    }

        public boolean add(T newEntry) {
            if (!(newEntry instanceof Student)) {
                System.out.print("Entry must be a Student object.");
                return false; // Return false to indicate the addition failed
            }

            Student newStudent = (Student) newEntry; // Cast the entry to Student

            // Validate the ID format (should start with "220" and have 4 digits)
            String idString = String.valueOf(newStudent.getIdNo());
            if (!idString.matches("^220\\d{4}$")) {
                System.out.println("Invalid ID format. ID must start with '220' and be followed by 4 digits.");
                return false; // Return false to indicate the addition failed
            }

            // Check if the student ID already exists in the tutorial group
            for (int i = 0; i < numberOfEntries; i++) {
                if (array[i].getIdNo() == newStudent.getIdNo()) {
                    System.out.println("Student with ID " + newStudent.getIdNo() + " already exists.");
                    return false; // Return false to indicate the addition failed
                }
            }

            int i = 0;
            while (i < numberOfEntries && newStudent.compareTo(array[i]) > 0) {
                i++;
            }
            makeRoom(i + 1);
            array[i] = newStudent; // Store the new Student object in the array
            numberOfEntries++;
            return true;
        }
@Override
public boolean remove(T anEntry) {
    if (!(anEntry instanceof Student)) {
         System.out.print("Entry must be a Student object.");
    }

    Student targetStudent = (Student) anEntry; // Cast the entry to Student
    int index = 0;
    while (index < numberOfEntries && targetStudent.compareTo(array[index]) > 0) {
        index++;
    }
    if (index < numberOfEntries && targetStudent.equals(array[index])) {
        removeGap(index + 1);
        numberOfEntries--;
        return true;
    }
    return false;
}
  
 public void list() {
      System.out.println("STUDENT LIST");
    for (int i = 0; i < numberOfEntries; i++) {
        System.out.println(array[i].toString());
    }
}
  public void clear() {
    numberOfEntries = 0;
  }

  public T find(int id) {
            for (int i = 0; i < numberOfEntries; i++) {
                if (array[i].getIdNo() == id) {
                    return (T) array[i];
                }
            }
            return null; // Return null if not found
        }
  
  public void filter(Object prefix) {
    for (int i = 0; i < numberOfEntries; i++) {
        String idString = String.valueOf(array[i].getIdNo());
        if (idString.startsWith(prefix.toString())) {
            System.out.println(array[i]);
        }
    }
}
  
public void generateReport() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Print headers with formatting
    System.out.printf("%-12s %-25s %-20s%n", "Student ID", "Student Name", "Entry Date/Time");

    // Variable to track whether headers have been printed
    boolean headersPrinted = false;

    for (int i = 0; i < numberOfEntries; i++) {
        Student student = array[i];
        GregorianCalendar entryDateTime = (GregorianCalendar) student.getEntryDateTime();
        String formattedDate = dateFormat.format(entryDateTime.getTime());

        // Check if it's the first entry and print headers
        if (!headersPrinted) {
            System.out.printf("%-12s %-25s %-20s%n", "-----------", "-------------------------", "------------------");
            headersPrinted = true;
        }

        // Print student information with formatting
        System.out.printf("%-12d %-25s %-20s%n", student.getIdNo(), student.getName(), formattedDate);
    }
}

public boolean Change(T studentChange, Object targetGroup) {
    if (!(studentChange instanceof Student)) {
        System.out.println("Invalid input types.");
        return false;
    }

    Student studentToChange = (Student) studentChange;

    // Check if the student exists in the current group
    if (contains(studentToChange)) {
        if (targetGroup == 1 && tutGroup2.contains(studentToChange)) {
            System.out.println("Student is already in Group 1. Cannot move to the same group.");
            return false;
        } else if (targetGroup == 2 && tutGroup.contains(studentToChange)) {
            System.out.println("Student is already in Group 2. Cannot move to the same group.");
            return false;
        } else {
            // Remove the student from the current group
            if (remove(studentToChange)) {
                if (targetGroup == 1) {
                    tutGroup.add(studentToChange);
                } else if (targetGroup == 2) {
                    tutGroup2.add(studentToChange);
                }
                System.out.println("Student moved successfully to Group " + targetGroup + ".");
                return true; // Successfully changed the student's tutorial group
            }
        }
    } else {
        System.out.println("Student not found in the current group.");
    }

    return false;
}

    
/*public boolean Change(T studentChange, Object changeTo) {
    if (!(studentChange instanceof Student) || !(changeTo instanceof TutGroupManagement)) {
        System.out.println("Invalid input types.");
        return false;
    }

    Student studentToChange = (Student) studentChange;
    TutGroupManagement<Student> targetGroup = (TutGroupManagement<Student>) changeTo;

    // Check if the student exists in the current group
    if (contains((T) studentToChange)) {
        // Remove the student from the current group
        if (remove((T) studentToChange)) {
            // Add the student to the target group
            targetGroup.add(studentToChange);
            System.out.println("Student moved successfully.");
            return true; // Successfully changed the student's tutorial group
        }
    }

    return false;
}*/

   
   //start from here all teacher code
  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < numberOfEntries); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }
    return found;
  }



  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < numberOfEntries; ++index) {
      outputStr += array[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return numberOfEntries == array.length;
  }


  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = numberOfEntries - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }
    private void doubleArray() {
    Student [] oldList = array;
    int oldSize = oldList.length;

    array = (T[]) new Object[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      array[index] = oldList[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = numberOfEntries - 1;

    
    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }
  }

