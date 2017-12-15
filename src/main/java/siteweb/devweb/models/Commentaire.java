package siteweb.devweb.models;

public class Commentaire {
        private int idmessage;
        private String user,user_email,message;
        public int getIdmessage() {
            return idmessage;
        }

        public Commentaire(String user,String user_email, String message){
            this.user=user;
            this.user_email=user_email;
            this.message=message;
        }
        public void setIdmessage(int idmessage) {
            this.idmessage = idmessage;
        }
        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }
        public String getUser_email() {
            return user_email;
        }
        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }


}
