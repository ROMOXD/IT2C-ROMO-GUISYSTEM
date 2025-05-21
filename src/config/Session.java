
package config;


public class Session {
    
   public static Session instance; 
   
   private int uid;
   private String fname;
   private String lname;
   private String email;
   private String cnum;
   private String username;
   private String password;
   private String gender;
   private String age;
   private String type;
   private String status;
   private String u_image;
   private boolean hasRecoveryQuestions;
   
   private Session(){
   
   
   
   
   }

    public static synchronized Session getInstance() {
        if(instance == null){
        instance = new Session();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getU_image() {
        return u_image;
    }

    public void setU_image(String u_image) {
        this.u_image = u_image;
    }

    public boolean isHasRecoveryQuestions() {
        return hasRecoveryQuestions;
    }

    public void setHasRecoveryQuestions(boolean hasRecoveryQuestions) {
        this.hasRecoveryQuestions = hasRecoveryQuestions;
    }
    
    
    
    
   
   
   
    
    
    
    
}
