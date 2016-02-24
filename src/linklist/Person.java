package linklist;

/**
 *A class named Person including all relevant general information for any one person.
 * Information includes social security number, first name, last name, email and DOB.
 * 
 */
public class Person 
{
    //declare properties  
        private String socialSecurityNumb;
        private String firstName;
        private String lastName;
        private String email;
        private String dateOfBirth;

        //constructor methods
        public Person()
        {
           this.socialSecurityNumb = "000000000";
           this.firstName = "John";
           this.lastName = "Doe";
           this.email = "Not Available";
           this.dateOfBirth = "Not Available"; 
        }

        public Person(String socialSecurityNumb, String firstName, String lastName, String email, String dateOfBirth) 
        {
            this.socialSecurityNumb = socialSecurityNumb;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
        }

        public Person(Person source)
        {
            this.copy(source);
        }

        //accessor methods

        public String getSocSecNumb()
        {
            return socialSecurityNumb;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public String getEmail()
        {
            return email;
        }

        public String getDateOfBirth()
        {
            return dateOfBirth;
        }

        //mutator methods
         public void setSocSecNumb(String socialSecurityNumb)
          {
              this.socialSecurityNumb = socialSecurityNumb;
          }

          public void setFirstName(String firstName)
          {
              this.firstName = firstName;
          }

          public void setLastName(String lastName)
          {
              this.lastName = lastName;
          }

          public void setEmail(String email)
          {
              this.email = email;
          }

           public void setDateOfBirth(String dateOfBirth)
          {
              this.dateOfBirth = dateOfBirth;
          }

          //method will return information about the Employee in their current state
          public String toString()
          {
              return ("First Name:" + firstName + "\n" + "Last Name:" + lastName + "\n" 
                      + "Social Security Number:" + socialSecurityNumb + "\n" + "Date of Birth:" + dateOfBirth + "\n"
                      + "email:" + email + "\n");
          }

        //compareTo method
        public int compareTo(Person b)
        {
            int result;
            result = this.socialSecurityNumb.compareTo(b.socialSecurityNumb);
            return result;
        }

        public void copy(Person source) 
          {
              this.socialSecurityNumb = source.socialSecurityNumb;
              this.firstName = source.firstName;
              this.lastName = source.lastName;
              this.dateOfBirth = source.dateOfBirth;
              this.email = source.email;
          }
        
        public void getPersonObjRef()
        {
            System.out.println(this);
        }
        
        public Person deepCopy()
        {
            Person newPerson = new Person(this.getSocSecNumb(),this.getFirstName(), this.getLastName(),this.getEmail(),this.getDateOfBirth());
            
            return newPerson;
        }
    
}//end Person class
