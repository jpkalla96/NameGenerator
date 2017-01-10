public class Name {
    private String name;
    private boolean isMale;

    public Name(String name, String gender) {
        this.name = name;
        switch (gender) {
            case "male":
                this.isMale = true;
                break;
            case "female":
                this.isMale = false;
                break;
            default:
                this.isMale = true;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isMale(boolean isMale) {
        if (isMale == this.isMale) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lastName(String lastName, boolean alliteration, boolean usage){
        if (usage == true){
            if (alliteration == true){
                return this.firstLetter(lastName.charAt(0), true, false);
            }else{
                if (lastName.charAt(0) == name.charAt(0)){
                    return false;
                }else{
                    return true;
                }
            }
        }else{
            return true;
        }
    }

    public boolean firstLetter(char firstLetter, boolean usage, boolean lastNameUse) {
        if (usage == true && lastNameUse == false) {
            if (firstLetter == name.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }
    }

    public boolean maxLength(int maxLength, boolean usage) {
        if (usage == true) {
            if (maxLength >= name.length()) {
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }
    }

    public boolean minLength(int minLength, boolean usage) {
        if (usage == true) {
            if (minLength <= name.length()) {
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }
    }
}
