package model;

import exception.InvalidInputParameters;

/**
 * Created by v21k on 20.02.17.
 */
public class User {
    private final String name;
    private String pass;
    private final String email;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.pass = builder.pass;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, email: %s\n", name, email);
    }

    public static class UserBuilder{
        private String name;
        private String pass;
        private String email;

        public UserBuilder setName(String name) throws InvalidInputParameters{
            if(name == null || name.length() == 0) throw new InvalidInputParameters("Name is empty");

            this.name = name;
            return this;
        }

        public UserBuilder setPass(String pass) throws InvalidInputParameters{
            if(pass == null || pass.length() == 0) throw new InvalidInputParameters("Pass is empty");

            this.pass = pass;
            return this;
        }

        public UserBuilder setEmail(String email) throws InvalidInputParameters{
            if(email == null) throw new InvalidInputParameters("Email is null");

            if(email.indexOf("@") == -1 || email.lastIndexOf(".") < email.indexOf("@"))
                throw new InvalidInputParameters("Incorrect email format!");

            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
